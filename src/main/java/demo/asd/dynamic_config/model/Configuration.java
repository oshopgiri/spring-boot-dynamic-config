package demo.asd.dynamic_config.model;

import java.io.File;

public class Configuration {
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
//        TODO:
//        1. check if config file exists, else return false
        File configFile = new File(System.getProperty("user.home") + "/gps-config.json");
//        2. load config file and set the above variables and ensure everything is loaded correctly, else return false

        return configFile.exists();
    }
}
