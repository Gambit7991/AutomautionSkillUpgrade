package base_pages;

import modal_windows.CreateBoardModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pojo.LoginPojoPage;

public class HomePage extends BasePage {
    private final String URL = "https://trello.com/u/radionovtymur/boards";
    @FindBy(xpath = "//ul[@class ='boards-page-board-section-list']/li[last()]")
    private WebElement createBoardArea;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    public boolean isSignedIn() {
        String xpath = "//span[@title= /'";
        String titleResult = xpath +
                LoginPojoPage.name +
                " (" +
                deleteEmailDomainPart(LoginPojoPage.email) +
                ")']";
        return waitVisibility(driver.findElement(By.xpath(titleResult))).isDisplayed();
    }

    private String deleteEmailDomainPart(String email) {
        return new StringBuilder(email).delete(getStartDomainIndex(email), email.length()).toString();
    }

    private int getStartDomainIndex(String email) {
        for (int i = email.length() - 1; i >= 0; i--) {
            if (email.charAt(i) == '@') {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public CreateBoardModalWindow createNewBoard(){
        createBoardArea.click();
        return new CreateBoardModalWindow(driver);
    }
}
