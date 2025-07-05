package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";
    private static boolean isLoaded = false;

    public static void loadProperties() {
        if (!isLoaded) {
            try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
                prop.load(fis);
                isLoaded = true;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load config.properties from path: " + CONFIG_PATH);
            }
        }
    }

    public static String getProperty(String key) {
        if (!isLoaded) {
            loadProperties();
        }
        return prop.getProperty(key);
    }
}
