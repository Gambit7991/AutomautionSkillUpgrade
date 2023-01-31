package flow;

import pom.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pojo.UserData;

public class LoginFlow extends BaseFlow{
    private final String URL = "https://trello.com/login";
    private  LoginPage loginPage;

    public LoginFlow(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        driver.get(URL);
    }

    @Step("LoginFlow.java trying to sign in")
    public HomeFlow signIn(UserData user) {
        sendStringKeys(loginPage.getEmailField(), user.getEmail());
        loginPage.getContinueBtn().click();
        sendStringKeys(waitVisibility(loginPage.getPasswordField()), user.getPassword());
        loginPage.getSubmitBtn().click();
        return new HomeFlow(driver);
    }

}
