package flow;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFlow {

    private final Duration TIME_OUT_SECONDS = Duration.ofSeconds(15);
    public WebDriver driver;
    public WebDriverWait wait;

    public BaseFlow(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, TIME_OUT_SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void sendStringKeys(WebElement element, String keys) {
        waitVisibility(element).sendKeys(keys);
//        element.sendKeys(keys);
    }

    public void selectById(int id, By xpath){
        Select select = new Select(driver.findElement(xpath));
        select.selectByIndex(id);
    }

    public WebElement waitVisibility(WebElement element) {
        return Assertions.assertDoesNotThrow(() -> wait.until(ExpectedConditions.visibilityOf(element)));
    }
    public WebElement isEnabled(WebElement element){
        return Assertions.assertDoesNotThrow(() -> wait.until(ExpectedConditions.elementToBeClickable(element)));
    }
}
