package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame extends CustomElement{
    public IFrame(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public IFrame switchTo(){
        driver.switchTo().frame(waitVisibility());
        return this;
    }
}
