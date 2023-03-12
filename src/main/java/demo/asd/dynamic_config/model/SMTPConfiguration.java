package demo.asd.dynamic_config.model;

public class SMTPConfiguration {
    String password;
    int port;
    String server;
    String username;

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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isValid() {
        return !password.isEmpty() &&
                (port != 0) &&
                !server.isEmpty() &&
                !username.isEmpty();
    }
}
