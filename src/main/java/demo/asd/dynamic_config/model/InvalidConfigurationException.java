package demo.asd.dynamic_config.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidConfigurationException extends Exception {
    public InvalidConfigurationException(String message) {
        super(message);
        log.error(message);
    }
}
