package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name= 'user' and @inputmode= 'email']")
    public WebElement emailField;
    @FindBy(xpath = "//input[@id= 'login' and @type= 'submit']")
    public WebElement continueBtn;
    @FindBy(xpath = "//input[@type= 'password']")
    public WebElement passwordField;
    @FindBy(xpath = "//button[@id= 'login-submit']")
    public WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}