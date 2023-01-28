package modal_windows;

import base_pages.BasePage;
import base_pages.BoardPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.BoardPojoModalWindow;

import java.io.IOException;

public class CreateBoardModalWindow extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement boardTitle;
    @FindBy(xpath = "//button[@data-testid= 'create-board-submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@id= 'background-picker']/ul/li[3]/button")
    private WebElement backGroundPicture;

    public CreateBoardModalWindow(WebDriver driver){
        super(driver);
    }

    @Step("creating board with custom visibility")
    public BoardPage createBoard(int visibility) throws IOException {
        WebElement element = waitVisibility(driver.findElement(By.xpath("//input[@id='react-select-3-input']")));
        switch (visibility){
            case 1 : waitVisibility(driver.findElement(By.xpath("//input[@id='react-select-3-option-1']"))).click();
            break;
            case 3 : waitVisibility(driver.findElement(By.xpath("//input[@id='react-select-3-option-3']"))).click();
            break;
        }
        waitVisibility(boardTitle).sendKeys(BoardPojoModalWindow.TITLE);
        submitButton.click();
        return new BoardPage(driver);
    }
    public BoardPage createBoard(){
        waitVisibility(boardTitle).sendKeys(BoardPojoModalWindow.TITLE);
        submitButton.click();
        return new BoardPage(driver);
    }

    public BoardPage createBoardWithBackground(){
        String temp = backGroundPicture.getCssValue("background-image");
        backGroundPicture.click();
        return createBoard().setSelectedBackground(temp);
    }
}
