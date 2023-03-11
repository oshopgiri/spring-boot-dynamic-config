package demo.asd.dynamic_config.model;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Configuration {
    public static final String CONFIG_FILE_PATH = System.getProperty("user.home") + "/gps.config";
    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

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

    public static void save(Configuration configuration) {
        File configFile = new File(CONFIG_FILE_PATH);

        try {
            if (configFile.createNewFile()) {
                FileWriter configWriter = new FileWriter(configFile);
                configWriter.write(new Gson().toJson(configuration));
                configWriter.close();
            } else {
                LOGGER.info("config file creation failed");
            }
        } catch (Exception e) {
            configFile.delete();
            e.printStackTrace();
        }
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

                System.setProperty("spring.datasource.password", configuration.getDatabase().getPassword());
                System.setProperty("spring.datasource.url", configuration.getDatabase().getURL());
                System.setProperty("spring.datasource.username", configuration.getDatabase().getUsername());
            } catch (FileNotFoundException e) {
                loaded = false;
                e.printStackTrace();
            }
        }

        return loaded;
    }
}
