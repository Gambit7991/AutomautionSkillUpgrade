package pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class BoardPage extends BasePage{
    @FindBy(xpath = "//div[@data-testid='workspace-boards-and-views-lists']")
    private WebElement boardName;
    @FindBy(xpath = "//div[@data-testid='collapsible-list'][2]/ul/div[2]/li")
    private List<WebElement> rawBoardList;


    public BoardPage(WebDriver driver) {
        super(driver);
    }
}