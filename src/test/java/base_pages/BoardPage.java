package base_pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.BoardPojoModalWindow;

public class BoardPage extends BasePage{
    @FindBy(xpath = "//a[@title= '" + BoardPojoModalWindow.TITLE + "']")
    private WebElement boardName;


    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement isBoardCreated(){
        return waitVisibility(boardName);
    }

}
