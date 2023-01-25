package modal_windows;

import base_pages.BasePage;
import base_pages.BoardPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.BoardPojoModalWindow;

public class CreateBoardModalWindow extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement boardTitle;
    @FindBy(xpath = "//button[@data-testid= 'create-board-submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@id= 'background-picker']/ul/li[3]/button")
    private WebElement backGroundPicture;

    public CreateBoardModalWindow(WebDriver driver){
        super(driver);
        waitVisibility(boardTitle);
    }
    @Step("creating board")
    public BoardPage createBoard(){
        boardTitle.sendKeys(BoardPojoModalWindow.TITLE);
        isEnabled(submitButton).click();
        return new BoardPage(driver);
    }
    public BoardPage createBoardWithBackground(){
        String temp = backGroundPicture.getCssValue("background-image");
        backGroundPicture.click();
        return createBoard().setSelectedBackground(temp);
    }
}
