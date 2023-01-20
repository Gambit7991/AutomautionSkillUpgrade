import base_pages.LoginPage;
import factories.UserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pojo.UserData;

public class MainPageTests {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private UserData user = new UserData();

    @BeforeEach
    public void createDriver() {
        //WebDriverManager has been added
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(new ChromeOptions()));
        //create user entity
        user = UserFactory.getUser();
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
                //user as a param for sign in method
                .signIn(user)
                .openCreateBoardModalWindow()
                .createBoard()
                .isBoardCreated()
                .isDisplayed()
        );
    }

    @Test
    public void login() {
        Assertions.assertTrue(new LoginPage(driver.get())
                //user as a param for sign in method
                .signIn(user)
                .isSignedIn()
        );
    }
}
