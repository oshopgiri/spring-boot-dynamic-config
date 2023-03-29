package demo.asd.dynamic_config;

import demo.asd.dynamic_config.main_application.MainApplication;
import demo.asd.dynamic_config.model.Configuration;
import demo.asd.dynamic_config.setup_application.SetupApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@Slf4j
public class Application extends SpringBootServletInitializer implements ApplicationContextAware {
    public static void restart() {
        if (context == null) {
            restartExternal();
        } else {
            restartNative();
        }
    }

    private static Class configure() {
        return Configuration.load() ? MainApplication.class : SetupApplication.class;
    }

// --------------------------------------------------------------------------------------------------------------------- embedded tomcat stuff
    private static ClassLoader mainThreadClassLoader;
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        mainThreadClassLoader = Thread.currentThread().getContextClassLoader();
        boot(args);
    }

    private static void boot(String[] args) {
        context = SpringApplication.run(configure(), args);
    }

    private static void restartNative() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            context.close();
            boot(args.getSourceArgs());
        });
// https://stackoverflow.com/a/60957691
        thread.setContextClassLoader(mainThreadClassLoader);
        thread.setDaemon(false);
        thread.start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = (ConfigurableApplicationContext) applicationContext;
    }
// --------------------------------------------------------------------------------------------------------------------- embedded tomcat stuff ends

// --------------------------------------------------------------------------------------------------------------------- external tomcat stuff
    private static void restartExternal() {
        try {
// https://stackoverflow.com/a/26301367
            String command = "curl --user admin:admin http://localhost:8080/manager/text/reload?path=/dynamic_config";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.configure());
    }
// --------------------------------------------------------------------------------------------------------------------- external tomcat stuff ends
}
