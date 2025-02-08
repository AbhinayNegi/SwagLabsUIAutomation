package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;
    private final String propertyFilePath = "src/test/resources/config.properties";

    public ConfigReader() {
        try (FileInputStream fis = new FileInputStream(propertyFilePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
