package factories;

import base_pages.PropertyName;
import pojo.UserData;
import properties.PropertyManager;

public class UserFactory {
    //Property manager is a class to work with property file
    private static final PropertyManager propertyManager = new PropertyManager("database.properties");

    // method getUser returns new User entity with received properties from file
    public static UserData getUser(){
        return UserData.builder()
                .email(propertyManager.getProperty(PropertyName.EMAIL))
                .name(propertyManager.getProperty(PropertyName.NAME))
                .password(propertyManager.getProperty(PropertyName.PASSWORD))
                .build();
    }
}
