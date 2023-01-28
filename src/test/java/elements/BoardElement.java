package elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardElement extends CustomElement {

    public BoardElement(WebDriver driver, WebElement board) {
        super(driver, board);
    }

    @Step("Get close board button")
    public WebElement getBoardCloseButton() {
        openBoardActionsMenu();
        return driver.findElement(By.xpath("//button[@title='Close']"));
    }

    @Step("Open board actions menu")
    public void openBoardActionsMenu() {
        waitVisibility().click();
        //TODO: почему во время дебага падает? ->
        element.findElement(By.xpath("div[2]/div/button/span/span")).click();
        openCloseBoardMenu();
    }

    @Step("Open close board menu")
    private void openCloseBoardMenu() {
        driver.findElement(By.xpath("//button[@title='Close board']")).click();
    }

}