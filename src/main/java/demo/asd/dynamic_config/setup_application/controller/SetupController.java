package demo.asd.dynamic_config.setup_application.controller;

import demo.asd.dynamic_config.Application;
import demo.asd.dynamic_config.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SetupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SetupController.class);

    @GetMapping("/")
    public String show() {
//        TODO: show configuration form

        return "setup_form";
    }

    @PostMapping("/update")
    public String update() {
//        TODO: read form data from params instead of hardcoding

        BasicConfiguration basicConfiguration = new BasicConfiguration();
        basicConfiguration.setBaseURL("url");
        basicConfiguration.setLogFilePath("log.file_path");

        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        databaseConfiguration.setHostname("localhost");
        databaseConfiguration.setName("dynamic_config");
        databaseConfiguration.setPassword("");
        databaseConfiguration.setPort(3306);
        databaseConfiguration.setUsername("root");

        SMTPConfiguration smtpConfiguration = new SMTPConfiguration();
        smtpConfiguration.setPassword("password");
        smtpConfiguration.setPort(1234);
        smtpConfiguration.setServer("localhost");
        smtpConfiguration.setUsername("username");

        LDAPConfigurtion ldapConfigurtion = new LDAPConfigurtion();
        ldapConfigurtion.setAdditionalUserDN("additionalUserDN");
        ldapConfigurtion.setAdministratorUsername("admin_user");
        ldapConfigurtion.setBaseDN("baseDN");
        ldapConfigurtion.setHostname("localhost");
        ldapConfigurtion.setPassword("password");
        ldapConfigurtion.setPort(8090);
        ldapConfigurtion.setUsername("username");

        Configuration configuration = new Configuration();
        configuration.setBasic(basicConfiguration);
        configuration.setDatabase(databaseConfiguration);
        configuration.setSMTP(smtpConfiguration);
        configuration.setLDAP(ldapConfigurtion);

        Configuration.save(configuration);
        Application.restart();
        return"configuration_saved";
    }
}
