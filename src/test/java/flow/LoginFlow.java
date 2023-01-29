package flow;

import base_pages.LoginPage;
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

    @Step("Sign in")
    public HomeFlow signIn(UserData user) {
        sendStringKeys(loginPage.emailField, user.getEmail());
        loginPage.continueBtn.click();
        sendStringKeys(waitVisibility(loginPage.passwordField), user.getPassword());
        loginPage.submitBtn.click();
        return new HomeFlow(driver);
    }

}
