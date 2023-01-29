package properties;

import utils.PropertyName;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private final Properties properties = new Properties();

    public  PropertyManager(String name) {
        try {
            properties.load(new FileReader(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getProperty(String name) {
        return properties.getProperty(name);
    }

    public String getProperty(PropertyName name) {
        return getProperty(name.toString().toLowerCase());
    }

}