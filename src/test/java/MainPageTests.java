import base_pages.LoginPage;
import factories.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class MainPageTests {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

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
        Assertions.assertTrue(new LoginPage(driver.get())
                .signIn()
                .isSignedIn());
    }
}
