package tests;

import flow.BoardModalFlow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base_pages.TestBasePage;

//@ExtendWith(ScreenshotExtension.class)
public class BoardTests extends TestBasePage {
    private BoardModalFlow boardModalWindow;

    @BeforeEach
    public void precondition() {
        boardModalWindow = login().getCreateBoardModalWindow();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    public void createNewBoard(int visibility) {
        Assertions.assertTrue(boardModalWindow
                .createBoard(visibility)
                .isBoardCreated()
        );
    }

    @Test
    public void closeBoard() {
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .closeBoard()
                .isBoardClosed()
        );
    }

    @Test
    public void createBoard(){
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .isBoardCreated());
    }
}