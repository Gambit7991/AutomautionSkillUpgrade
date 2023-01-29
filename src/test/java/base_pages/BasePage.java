package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
//        ElementLocatorFactory factory = new DefaultElementLocatorFactory(driver);
//        ElementDecorator decorator = new ElementDecorator(factory, driver);
        PageFactory.initElements(driver, this);

    }
}