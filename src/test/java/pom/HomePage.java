package pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage {
    @FindBy(xpath = "//ul[@class ='boards-page-board-section-list']/li[last()]")
    private WebElement createBoardArea;
    @FindBy(xpath = "//ul[@class='boards-page-board-section-list']")
    private WebElement boards;

    public HomePage(WebDriver driver) {
        super(driver);
    }

}