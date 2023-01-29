package modal_windows;

import base_pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBoardModalWindow extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    public WebElement boardTitle;
    @FindBy(xpath = "//button[@data-testid= 'create-board-submit-button']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@id= 'background-picker']/ul/li[3]/button")
    public WebElement backGroundPicture;

    public CreateBoardModalWindow(WebDriver driver) {
        super(driver);
    }
}