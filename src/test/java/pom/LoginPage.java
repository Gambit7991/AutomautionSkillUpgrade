package pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name= 'user' and @inputmode= 'email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id= 'login' and @type= 'submit']")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@type= 'password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id= 'login-submit']")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}