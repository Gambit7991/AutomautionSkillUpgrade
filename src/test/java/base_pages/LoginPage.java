package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.UserData;

public class LoginPage extends BasePage{
    private final String URL = "https://trello.com/login";
    @FindBy(xpath = "//input[@name= 'user' and @inputmode= 'email']")
    private WebElement emailField ;
    @FindBy(xpath = "//input[@id= 'login' and @type= 'submit']")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@type= 'password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id= 'login-submit']")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    public HomePage signIn(UserData user){
        sendStringKeys(emailField, user.getEmail());
        continueBtn.click();
        waitVisibility(passwordField);
        sendStringKeys(waitVisibility(passwordField), user.getPassword());
        submitBtn.click();
        return new HomePage(driver);
    }
}
