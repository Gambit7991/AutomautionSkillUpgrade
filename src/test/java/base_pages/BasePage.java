package base_pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BasePage {
    private final Duration TIME_OUT_SECONDS = Duration.ofSeconds(10);
    public WebDriver driver;
    public WebDriverWait wait;
    public static Properties properties = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, TIME_OUT_SECONDS);
        PageFactory.initElements(driver, this);
        try {
            properties.load(new FileReader("database.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendStringKeys(WebElement element, String keys) {
        //TODO : Should be finished, need to check if element is a text field or a button
        if (element.getTagName().equals("input")) {
            element.sendKeys(keys);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void selectById(int id, By xpath){
        Select select = new Select(driver.findElement(xpath));
        select.selectByIndex(id);
    }

    public WebElement waitVisibility(WebElement element) {
        return Assertions.assertDoesNotThrow(() -> wait.until(ExpectedConditions.visibilityOf(element)));
    }

    private static String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static String getProperty(PropertyName name) {
        return getProperty(name.toString().toLowerCase());
    }

    public WebElement isEnabled(WebElement element){
        return Assertions.assertDoesNotThrow(() -> wait.until(ExpectedConditions.elementToBeClickable(element)));
    }
}