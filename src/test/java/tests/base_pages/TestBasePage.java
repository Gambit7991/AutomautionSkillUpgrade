package tests.base_pages;

import base_pages.HomePage;
import base_pages.LoginPage;
import ch.qos.logback.classic.Logger;
import factories.UserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import pojo.UserData;

public abstract class TestBasePage {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public UserData user = new UserData();
    public final Logger logger
            = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.foobar");
    public HomePage homePage;

    @BeforeEach
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(new ChromeOptions()));
        user = UserFactory.getUser();
//        homePage = login();
    }

    @AfterEach
    public void afterEach() {
        if (driver.get() != null) {
            driver.get().close();
        }
    }

    public HomePage login(){
        return new LoginPage(driver.get())
                .signIn(user);
    }
}
