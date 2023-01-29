package flow;

import base_pages.BoardPage;
import elements.BoardElement;
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

    public boolean isBoardCreated() {
        return waitVisibility(board.boardName).isDisplayed();
    }

    public BoardFlow closeBoard() {
        isBoardCreated();
        setBoards();
        boards
                .get(0)
                .getBoardCloseButton()
                .click();
        return this;
    }

    public boolean isBoardClosed() {
        driver.get("https://trello.com/b/Ua84IIX7/anotherone");
        return board.rawBoardList.size() < boards.size();
    }

    private void setBoards() {
        board.rawBoardList.forEach(el -> boards.add(new BoardElement(driver, el)));
    }

    private void init() {
        board = new BoardPage(driver);
    }

}