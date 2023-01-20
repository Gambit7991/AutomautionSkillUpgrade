package pojo;

import base_pages.BasePage;
import base_pages.PropertyName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class LoginPojoPage {
    public static String email = BasePage.getProperty(PropertyName.EMAIL);
    public static String password = BasePage.getProperty(PropertyName.PASSWORD);
    public static String name = BasePage.getProperty(PropertyName.NAME);

    public String toString(){
        return "LoginPojo properties : \n Login : %s,\n Password : %s,\n ";
    }

}
