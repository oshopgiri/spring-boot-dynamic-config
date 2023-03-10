package demo.asd.dynamic_config.main_application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"demo.asd.dynamic_config.main_application"})
@SpringBootApplication(scanBasePackages = {"demo.asd.dynamic_config.main_application"})
public class MainApplication {
}
