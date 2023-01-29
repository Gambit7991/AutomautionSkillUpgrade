package flow;

import base_pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeFlow extends BaseFlow {

    private HomePage homePage;

    public HomeFlow(WebDriver driver) {
        super(driver);
        init();
    }

    public boolean isSignedIn() {
        return waitVisibility(homePage.boards).isDisplayed();
    }

    public BoardModalFlow getCreateBoardModalWindow() {
        waitVisibility(homePage.createBoardArea).click();
        return new BoardModalFlow(driver);
    }

    private void init() {
        homePage = new HomePage(driver);
    }
}