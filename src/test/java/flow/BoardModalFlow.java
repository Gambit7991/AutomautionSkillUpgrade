package flow;

import io.qameta.allure.Step;
import modal_windows.CreateBoardModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pojo.BoardPojoModalWindow;

public class BoardModalFlow  extends BaseFlow {

    CreateBoardModalWindow boardModal;

    public BoardModalFlow(WebDriver driver) {
        super(driver);
        init();
    }
//TODO: Can not find a way to click on dropdown and choose an element
    @Step("creating board with custom visibility")
    public BoardFlow createBoard(int visibility) {
        WebElement element = waitVisibility(driver.findElement(By.xpath("//*[@id=\"react-select-7-input\"]")));
        element.click();
        switch (visibility) {
            case 1 -> waitVisibility(driver.findElement(By.xpath("//input[@id='react-select-3-option-1']"))).click();
            case 3 -> waitVisibility(driver.findElement(By.xpath("//input[@id='react-select-3-option-3']"))).click();
        }
        waitVisibility(boardModal.boardTitle).sendKeys(BoardPojoModalWindow.TITLE);
        boardModal.submitButton.click();
        return new BoardFlow(driver);
    }
    public BoardFlow createBoard(){
        waitVisibility(boardModal.boardTitle).sendKeys(BoardPojoModalWindow.TITLE);
        boardModal.submitButton.click();
        return new BoardFlow(driver);
    }

    public void init(){
        boardModal = new CreateBoardModalWindow(driver);
    }
}
