package demo.asd.dynamic_config.model;

public class BasicConfiguration {
    String BaseURL;
    String LogFilePath;

    public String getBaseURL() {
        return BaseURL;
    }

    public void setBaseURL(String baseURL) {
        BaseURL = baseURL;
    }

    public String getLogFilePath() {
        return LogFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        LogFilePath = logFilePath;
    }
}
