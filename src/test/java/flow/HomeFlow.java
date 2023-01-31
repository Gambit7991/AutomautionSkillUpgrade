package flow;

import pom.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomeFlow extends BaseFlow {

    private HomePage homePage;

    public HomeFlow(WebDriver driver) {
        super(driver);
        init();
    }
    @Step("HomeFlow.java checking if signed in")
    public boolean isSignedIn() {
        return waitVisibility(homePage.getBoards()).isDisplayed();
    }

    @Step("BoardFlow.java getting board modal window to create a board")
    public BoardModalFlow getCreateBoardModalWindow() {
        waitVisibility(homePage.getCreateBoardArea()).click();
        return new BoardModalFlow(driver);
    }

    private void init() {
        homePage = new HomePage(driver);
    }
}