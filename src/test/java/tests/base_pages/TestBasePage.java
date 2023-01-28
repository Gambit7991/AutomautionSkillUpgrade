package tests.base_pages;

import base_pages.HomePage;
import base_pages.LoginPage;
import ch.qos.logback.classic.Logger;
import factories.UserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import pojo.UserData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class TestBasePage implements AfterTestExecutionCallback {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public UserData user = new UserData();
    public final Logger logger
            = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback.tests");


    @BeforeEach
    public void preCondition() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(new ChromeOptions()));
        user = UserFactory.getUser();
    }

    @AfterEach
    public void afterEach() {

        if (driver.get() != null) {
            driver.get().close();
        }
    }

    public HomePage login() {
        return new LoginPage(driver.get())
                .signIn(user);
    }


    @Attachment(value = "{testName} - screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure(String testName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Object test = extensionContext.getRequiredTestInstance();
        Field a = test.getClass().getDeclaredField("driver");
        a.setAccessible(true);
        driver.set((WebDriver) a.get(test));
        Method method = extensionContext.getRequiredTestMethod();
        if (extensionContext.getExecutionException().isPresent()) {
            makeScreenshotOnFailure(method.getName());
        }
    }
}
