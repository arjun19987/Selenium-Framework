package org.project.supportLibraries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

    private static final Properties properties = loadFromPropertiesFile();
    static Logger log = LogManager.getLogger(Settings.class);

    /**
     * Method to get the properties instance.
     * @return properties instance
     */
    public static Properties getInstance() {
        return properties;
    }

    /**
     * Method to load properties from the GlobalSettings.properties file.
     * @return properties loaded from the file
     */
    private static Properties loadFromPropertiesFile() {
        Properties properties = new Properties();
        try {
            String propertiesFilePath = Paths.get(System.getProperty("user.dir"),
                    "src", "main", "resources", "configs", "GlobalSettings.properties").toString();
            properties.load(Files.newInputStream(Paths.get(propertiesFilePath)));
        } catch (Exception e) {
            log.error("Error loading properties file: {}", e.getMessage());
        }
        return properties;
    }

    /**
     * Method to get a property value by key.
     * @param key the key of the property to retrieve
     * @return the value of the property
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
