package demo.asd.dynamic_config.setup_application.controller;

import demo.asd.dynamic_config.Application;
import demo.asd.dynamic_config.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;

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
//        TODO: save form data to config file

        BasicConfiguration basicConfiguration = new BasicConfiguration();
        basicConfiguration.setBaseURL("urll");
        basicConfiguration.setLogFilePath("c:users");

        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        databaseConfiguration.setDbName("test");
        databaseConfiguration.setDbHostname("sa");
        databaseConfiguration.setDbPort("1433");
        databaseConfiguration.setDbUsername("sa");
        databaseConfiguration.setDbPassword("123");

        SMTPConfiguration smtpConfiguration = new SMTPConfiguration();
        smtpConfiguration.setSmtpPassword("8090");
        smtpConfiguration.setSmtpServer("asfdd");
        smtpConfiguration.setSmtpUsername("raj");
        smtpConfiguration.setSmtpPassword("sdas@ed");

        LDAPConfigurtion ldapConfigurtion = new LDAPConfigurtion();
        ldapConfigurtion.setLdapHostname("ldaphost");
        ldapConfigurtion.setLdapUsername("ldapusername");
        ldapConfigurtion.setLdapPort("8090");
        ldapConfigurtion.setLdapAdministratorUser("admin user");
        ldapConfigurtion.setLdapPassword("ldappassword");
        ldapConfigurtion.setLdapBaseDN("baseDN");
        ldapConfigurtion.setLdapAdditionalUserDN("ldapadduser");

        Configuration configuration = new Configuration();
        configuration.setBasic(basicConfiguration);
        configuration.setDatabase(databaseConfiguration);
        configuration.setSmtp(smtpConfiguration);
        configuration.setLdap(ldapConfigurtion);

        LOGGER.info(System.getProperty("user.home"));
        File configFile = new File(System.getProperty("user.home") + "/gps-config.json");
        try {
            if (configFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/gps-config.json");
                Gson gson = new Gson();

                String data = gson.toJson(configuration);
                fileWriter.write(data);
                fileWriter.close();
            } else {
                LOGGER.info("config file creation failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Application.restart();
        return"configuration_saved";
    }
}
