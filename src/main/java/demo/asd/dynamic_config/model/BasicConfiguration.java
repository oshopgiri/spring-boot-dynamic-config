package demo.asd.dynamic_config.model;

public class BasicConfiguration {
    String baseURL;
    String logFilePath;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public boolean isValid() {
        return !baseURL.isEmpty() &&
                !logFilePath.isEmpty();
    }
}
