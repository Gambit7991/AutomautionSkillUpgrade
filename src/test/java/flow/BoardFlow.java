package flow;

import pom.BoardPage;
import elements.BoardElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BoardFlow extends BaseFlow {
    private BoardPage board;

    private final List<BoardElement> boards = new ArrayList<>();


    public BoardFlow(WebDriver driver) {
        super(driver);
        init();
    }
    @Step("BoardFlow.java checking if board has been created")
    public boolean isBoardCreated() {
        return waitVisibility(board.getBoardName()).isDisplayed();
    }

    @Step("BoardFlow.java trying to close the board")
    public BoardFlow closeBoard() {
        isBoardCreated();
        setBoards();
        boards
                .get(0)
                .getBoardCloseButton()
                .click();
        return this;
    }
    @Step("BoardFlow.java checking if board has been closed")
    public boolean isBoardClosed() {
        driver.get("https://trello.com/b/Ua84IIX7/anotherone");
        return board.getRawBoardList().size() < boards.size();
    }

    private void setBoards() {
        board.getRawBoardList().forEach(el -> boards.add(new BoardElement(driver, el)));
    }

    private void init() {
        board = new BoardPage(driver);
    }

}