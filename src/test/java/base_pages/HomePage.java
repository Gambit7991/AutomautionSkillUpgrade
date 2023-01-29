package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//ul[@class ='boards-page-board-section-list']/li[last()]")
    public WebElement createBoardArea;
    @FindBy(xpath = "//ul[@class='boards-page-board-section-list']")
    public WebElement boards;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}