package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField extends CustomElement{
    public TextField(WebDriver driver, WebElement webElement) {
        super(webElement,driver);
    }

    public TextField editText(String text){
        element.sendKeys(text);
        return this;
    }


}