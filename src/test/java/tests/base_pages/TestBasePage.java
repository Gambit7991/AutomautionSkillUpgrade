package tests.base_pages;

import ch.qos.logback.classic.Logger;
import factories.UserFactory;
import flow.HomeFlow;
import flow.LoginFlow;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import pojo.UserData;
import tests.junit_extension.ScreenshotExtension;
@ExtendWith(ScreenshotExtension.class)
public abstract class TestBasePage {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public UserData user = new UserData();
    public final Logger logger
            = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback.tests");


    @BeforeEach
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(new ChromeOptions()));
        ScreenshotExtension.setDriver(driver.get());
        user = UserFactory.getUser();
    }

    @AfterEach
    public void afterEach() {
        if (driver.get() != null) {
            driver.get().close();
        }
    }

    public HomeFlow login() {
        return new LoginFlow(driver.get())
                .signIn(user);
    }
}