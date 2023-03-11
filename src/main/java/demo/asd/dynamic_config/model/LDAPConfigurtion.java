package demo.asd.dynamic_config.model;

public class LDAPConfigurtion {
    String additionalUserDN;
    String administratorUsername;
    String baseDN;
    String hostname;
    String password;
    int port;
    String username;

    public String getAdditionalUserDN() {
        return additionalUserDN;
    }

    public void setAdditionalUserDN(String additionalUserDN) {
        this.additionalUserDN = additionalUserDN;
    }

    public String getAdministratorUsername() {
        return administratorUsername;
    }

    public void setAdministratorUsername(String administratorUsername) {
        this.administratorUsername = administratorUsername;
    }

    public String getHostname() {
        return hostname;
    }

    public String getBaseDN() {
        return baseDN;
    }

    public void setBaseDN(String baseDN) {
        this.baseDN = baseDN;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
