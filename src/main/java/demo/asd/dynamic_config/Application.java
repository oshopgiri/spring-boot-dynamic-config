package demo.asd.dynamic_config;

import demo.asd.dynamic_config.main_application.MainApplication;
import demo.asd.dynamic_config.model.Configuration;
import demo.asd.dynamic_config.setup_application.SetupApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class Application extends SpringBootServletInitializer {
    private static Class applicationClass;
    private static ClassLoader mainThreadClassLoader;
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        mainThreadClassLoader = Thread.currentThread().getContextClassLoader();
        configure();
        boot(args);
//        context = SpringApplication.run(SetupApplication.class, args);
    }

    public static void restart() {
        configure();

//        TODO: Use Configuration class to initialize application.properties

        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            if (context != null) context.close();
            boot(args.getSourceArgs());
//            context = SpringApplication.run(MainApplication.class, args.getSourceArgs());
        });
//        https://stackoverflow.com/a/60957691
        thread.setContextClassLoader(mainThreadClassLoader);
        thread.setDaemon(false);
        thread.start();

//        FIXME: this doesn't redirect
//        return "/";
    }

    private static void boot(String[] args) {
        context = SpringApplication.run(applicationClass, args);
    }

    private static void configure() {
        applicationClass = Configuration.load() ? MainApplication.class : SetupApplication.class;
    }
}
