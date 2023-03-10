package demo.asd.dynamic_config.model;

import java.util.Map;

public class Configuration {
    public static Map<String, String> basic;
    public static Map<String, String> database;
    public static Map<String, String> gps;
    public static Map<String, String> ldap;
    public static Map<String, String> smtp;

    public static boolean load() {
//        TODO:
//        1. check if config file exists, else return false
//        2. load config file and set the above variables and ensure everything is loaded correctly, else return false

        return false;
    }

    private Configuration() {
    }
}
