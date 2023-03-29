package demo.asd.dynamic_config;

import demo.asd.dynamic_config.main_application.MainApplication;
import demo.asd.dynamic_config.model.Configuration;
import demo.asd.dynamic_config.setup_application.SetupApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@Slf4j
public class Application extends SpringBootServletInitializer {
    public static void restart() {
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

    private static Class configure() {
        return Configuration.load() ? MainApplication.class : SetupApplication.class;
    }
}
