package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesUtils {
    private static final String PROPERTY_FILE_NAME = "common.properties";

    private PropertiesUtils() {
    }

    public static String getProperty(String propertyName) {
        return readPropFile().getProperty(propertyName);
    }

    private static Properties readPropFile() {
        Properties prop = new Properties();
        try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME)) {
            prop.load(input);
        } catch (IOException e) {
			log.error("Can't read property from file!", new RuntimeException(e));
        }
        return prop;
    }
}
