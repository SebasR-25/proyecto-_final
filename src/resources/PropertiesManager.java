package resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static PropertiesManager instance;
    private final Properties properties;

    private PropertiesManager() {
        try {
            properties = new Properties();
            properties.load(new FileReader("src/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file");
        }
    }

    public static PropertiesManager getInstance() {
        if (instance == null) instance = new PropertiesManager();
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
