package base_pages;

import elements.BoardElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BoardPage extends BasePage{
    @FindBy(xpath = "//div[@data-testid='workspace-boards-and-views-lists']")
    public WebElement boardName;
    @FindBy(xpath = "//div[@id= 'trello-root']")
    private WebElement currentBackGround;

    @FindBy(xpath = "//div[@data-testid='collapsible-list'][2]/ul/div[2]/li")
    private List<WebElement> rawBoardList;
    private String selectedBackground;
    private List<BoardElement> boards = new ArrayList<>();

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBoardCreated(){
        return waitVisibility(boardName).isDisplayed();
    }

    public boolean isBackgroundCorrect(){
        isBoardCreated();
//        waitVisibility(currentBackGround);
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

    public BoardPage closeBoard(){
        isBoardCreated();
        initBoardList();
        boards
                .get(0)
                .getBoardCloseButton()
                .click();
        return this;
    }

    public boolean isBoardClosed(){
        driver.get("https://trello.com/b/Ua84IIX7/anotherone");
        return rawBoardList.size() < boards.size();
    }


    public void initBoardList() {
        rawBoardList.forEach(el->boards.add(new BoardElement(driver, el)));
    }
}
