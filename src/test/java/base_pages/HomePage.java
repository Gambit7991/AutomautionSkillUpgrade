package base_pages;

import modal_windows.CreateBoardModalWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private final String URL = "https://trello.com/u/radionovtymur/boards";
    @FindBy(xpath = "//ul[@class ='boards-page-board-section-list']/li[last()]")
    private WebElement createBoardArea;
    @FindBy(xpath = "//ul[@class='boards-page-board-section-list']")
    private WebElement boards;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    public boolean isSignedIn() {
        return waitVisibility(boards).isDisplayed();
    }

    public CreateBoardModalWindow openCreateBoardModalWindow(){
        createBoardArea.click();
        return new CreateBoardModalWindow(driver);
    }
}