package demo.asd.dynamic_config;

import demo.asd.dynamic_config.main_application.MainApplication;
import demo.asd.dynamic_config.model.Configuration;
import demo.asd.dynamic_config.setup_application.SetupApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Application {
    private static Class applicationClass;
    private static ClassLoader mainThreadClassLoader;
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        mainThreadClassLoader = Thread.currentThread().getContextClassLoader();
        configure();
        boot(args);
    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            if (context != null) context.close();
            configure();
            boot(args.getSourceArgs());
        });
//        https://stackoverflow.com/a/60957691
        thread.setContextClassLoader(mainThreadClassLoader);
        thread.setDaemon(false);
        thread.start();
    }

    private static void boot(String[] args) {
        context = SpringApplication.run(applicationClass, args);
    }

    private static void configure() {
        applicationClass = Configuration.load() ? MainApplication.class : SetupApplication.class;
    }
}
