package demo.asd.dynamic_config.model;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Configuration {
    public static String CONFIG_FILE_PATH = System.getProperty("user.home") + "/gps-config.json";

    BasicConfiguration basic;
    DatabaseConfiguration database;
    LDAPConfigurtion ldap;
    SMTPConfiguration smtp;

    public BasicConfiguration getBasic() {
        return basic;
    }

    public void setBasic(BasicConfiguration basic) {
        this.basic = basic;
    }

    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    public LDAPConfigurtion getLdap() {
        return ldap;
    }

    public void setLdap(LDAPConfigurtion ldap) {
        this.ldap = ldap;
    }

    public SMTPConfiguration getSmtp() {
        return smtp;
    }

    public void setSmtp(SMTPConfiguration smtp) {
        this.smtp = smtp;
    }

    public static boolean load() {
        File configFile = new File(CONFIG_FILE_PATH);
        boolean exists = configFile.exists();

        if (exists) {
            Gson gson = new Gson();

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile));
                Configuration configuration = gson.fromJson(bufferedReader, Configuration.class);

                System.setProperty("spring.datasource.password", configuration.getDatabase().getDbPassword());
                System.setProperty("spring.datasource.url", configuration.getDatabase().getDbUrl());
                System.setProperty("spring.datasource.username", configuration.getDatabase().getDbUsername());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return exists;
    }
}
