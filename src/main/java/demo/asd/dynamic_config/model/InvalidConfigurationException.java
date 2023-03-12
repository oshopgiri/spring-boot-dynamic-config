package demo.asd.dynamic_config.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidConfigurationException extends Exception {
    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

    public InvalidConfigurationException(String message) {
        super(message);

        LOGGER.error(message);
    }
}
