package demo.asd.dynamic_config.model;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class Configuration {
    public static final String CONFIG_FILE_PATH = System.getProperty("user.home") + "/gps.config";

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

    public LDAPConfigurtion getLDAP() {
        return ldap;
    }

    public void setLDAP(LDAPConfigurtion ldap) {
        this.ldap = ldap;
    }

    public SMTPConfiguration getSMTP() {
        return smtp;
    }

    public void setSMTP(SMTPConfiguration smtp) {
        this.smtp = smtp;
    }

    public boolean isValid() throws InvalidConfigurationException {
        boolean valid = basic.isValid() &&
                database.isValid() &&
                ldap.isValid() &&
                smtp.isValid();

        if (!valid) throw new InvalidConfigurationException("configuration file is invalid");

        return true;
    }

    public static boolean load() {
        File configFile = new File(CONFIG_FILE_PATH);
        boolean loaded = configFile.exists();

        if (loaded) {
            try {
                Configuration configuration = new Gson().fromJson(
                        new BufferedReader(new FileReader(configFile)),
                        Configuration.class
                );
                configuration.isValid();

                System.setProperty("spring.datasource.password", configuration.getDatabase().getPassword());
                System.setProperty("spring.datasource.url", configuration.getDatabase().getURL());
                System.setProperty("spring.datasource.username", configuration.getDatabase().getUsername());
            } catch (FileNotFoundException | InvalidConfigurationException e) {
                loaded = false;
                e.printStackTrace();
            }
        }

        return loaded;
    }

    public static void save(Configuration configuration) {
        File configFile = new File(CONFIG_FILE_PATH);
        try {
            configuration.isValid();

            if (configFile.createNewFile()) {
                FileWriter configWriter = new FileWriter(configFile);
                configWriter.write(new Gson().toJson(configuration));
                configWriter.close();
            } else {
                log.error("config file creation failed");
            }
        } catch (Exception e) {
            configFile.delete();
            e.printStackTrace();
        }
    }
}
