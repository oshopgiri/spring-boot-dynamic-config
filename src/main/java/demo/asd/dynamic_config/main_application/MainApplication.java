package demo.asd.dynamic_config.main_application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// TODO: remove @EnableAutoConfiguration.exclude
@EnableAutoConfiguration(
        exclude = {
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)
// TODO: uncomment @EnableJpaRepositories
// https://stackoverflow.com/a/54663039
// @EnableJpaRepositories(basePackages = {"demo.asd.dynamic_config.main_application"})
@SpringBootApplication(scanBasePackages = {"demo.asd.dynamic_config.main_application"})
public class MainApplication {
}
