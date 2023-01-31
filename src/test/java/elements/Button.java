package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends CustomElement {

    public Button(WebDriver driver, WebElement webElement) {
        super(webElement, driver);
    }

    public void click(){
        waitClickability().click();
    }
}