package demo.asd.dynamic_config.model;

public class LDAPConfigurtion {
    String ldapHostname;
    String ldapPort;
    String ldapUsername;
    String ldapPassword;
    String ldapBaseDN;
    String ldapAdditionalUserDN;
    String ldapAdministratorUser;

    public String getLdapHostname() {
        return ldapHostname;
    }

    public void setLdapHostname(String ldapHostname) {
        this.ldapHostname = ldapHostname;
    }

    public String getLdapPort() {
        return ldapPort;
    }

    public void setLdapPort(String ldapPort) {
        this.ldapPort = ldapPort;
    }

    public String getLdapUsername() {
        return ldapUsername;
    }

    public void setLdapUsername(String ldapUsername) {
        this.ldapUsername = ldapUsername;
    }

    public String getLdapPassword() {
        return ldapPassword;
    }

    public void setLdapPassword(String ldapPassword) {
        this.ldapPassword = ldapPassword;
    }

    public String getLdapBaseDN() {
        return ldapBaseDN;
    }

    public void setLdapBaseDN(String ldapBaseDN) {
        this.ldapBaseDN = ldapBaseDN;
    }

    public String getLdapAdditionalUserDN() {
        return ldapAdditionalUserDN;
    }

    public void setLdapAdditionalUserDN(String ldapAdditionalUserDN) {
        this.ldapAdditionalUserDN = ldapAdditionalUserDN;
    }

    public String getLdapAdministratorUser() {
        return ldapAdministratorUser;
    }

    public void setLdapAdministratorUser(String ldapAdministratorUser) {
        this.ldapAdministratorUser = ldapAdministratorUser;
    }
}
