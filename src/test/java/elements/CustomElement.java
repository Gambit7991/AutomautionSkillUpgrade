package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomElement {
    private final Duration TIME_OUT_SECONDS = Duration.ofSeconds(10);
    protected WebDriver driver;
    protected WebDriverWait wait;
    public WebElement element;

    public CustomElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.element = webElement;
        this.wait = new WebDriverWait(driver, TIME_OUT_SECONDS);
    }

    public WebElement waitVisibility() {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitClickability(){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
