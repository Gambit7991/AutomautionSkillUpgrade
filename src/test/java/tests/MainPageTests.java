package tests;

import base_pages.LoginPage;
import factories.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pojo.User;
import properties.PropertyData;
import properties.PropertyHandler;

public class MainPageTests {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeAll
    void manageProperties() {
        PropertyHandler.getData();
    }

    @BeforeEach
    public void createDriver() {
        driver.set(WebDriverFactory.getChromeDriver());
    }

    @AfterEach
    public void afterEach() {
        if (driver.get() != null) {
            driver.get().close();
        }
    }

    @Test
    public void createNewBoard() {
        Assertions.assertTrue(new LoginPage(driver.get())
                .signIn()
                .createNewBoard()
                .createBoard()
                .isBoardCreated()
                .isDisplayed());
    }

    @Test
    public void login() {
//        User user = User.builder()
//                .email(PropertyData.email)
//                .name(PropertyData.name)
//                .password(PropertyData.pass)
//                .build();
        Assertions.assertTrue(new LoginPage(driver.get())
                .signIn()
                .isSignedIn());
    }
}
