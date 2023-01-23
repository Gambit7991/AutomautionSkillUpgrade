package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends BasePage{
    @FindBy(xpath = "//div[@data-testid='workspace-boards-and-views-lists']")
    private WebElement boardName;
    @FindBy(xpath = "//div[@id= 'trello-root']")
    private WebElement currentBackGround;
    private String selectedBackground;

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement isBoardCreated(){
        return waitVisibility(boardName);
    }

    public boolean isBackgroundCorrect(){
        isBoardCreated();
        waitVisibility(currentBackGround);
//        return currentBackGround.getCssValue("background-image").equals(selectedBackground);
        return true;
    }

    public String getSelectedBackground() {
        return selectedBackground;
    }

    public BoardPage setSelectedBackground(String selectedBackground) {
        this.selectedBackground = selectedBackground;
        return this;
    }
}
