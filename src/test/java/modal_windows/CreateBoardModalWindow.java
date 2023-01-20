package modal_windows;

import base_pages.BasePage;
import base_pages.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.BoardPojoModalWindow;

public class CreateBoardModalWindow extends BasePage {
    private final String URL = "https://trello.com/u/radionovtymur/boards";
    @FindBy(xpath = "//input[@type='text']")
    private WebElement boardTitle;
    @FindBy(xpath = "//button[@data-testid= 'create-board-submit-button']")
    private WebElement modalTitle;
    @FindBy(xpath = "//div[contains(@id, 'create-board-select-visibility')]//div[contains(., 'Workspace')]")
    private WebElement dropdown;

    public CreateBoardModalWindow(WebDriver driver){
        super(driver);
//        driver.get(URL);
        waitVisibility(boardTitle);
    }
//TODO: Board visibility - ???? how to choose it, I thought through select but there is no select
    public BoardPage createBoard(){
        boardTitle.sendKeys(BoardPojoModalWindow.TITLE);
        dropdown.click();
        isEnabled(modalTitle).click();
        return new BoardPage(driver);
    }
}
