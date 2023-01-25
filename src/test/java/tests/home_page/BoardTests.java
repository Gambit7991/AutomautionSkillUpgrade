package tests.home_page;

import modal_windows.CreateBoardModalWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base_pages.TestBasePage;

public class BoardTests extends TestBasePage {
    private CreateBoardModalWindow boardModalWindow;

    @BeforeEach
    public void precondition() {
        boardModalWindow = login().openCreateBoardModalWindow();
    }

    @Test
    public void createNewBoard() {
        logger.info("Create new board process started");
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .isBoardCreated()
        );
        logger.info("Create new board process finished");
    }

    @Test
    public void checkSelectedBackgroundPicture() {
        logger.info("Create new board custom background process started");
        Assertions.assertTrue(boardModalWindow
                .createBoardWithBackground()
                .isBackgroundCorrect()
        );
        logger.info("Create new board custom background process finished");
    }

    @Test
    public void closeBoard() {
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .closeBoard()
                .isBoardClosed()
        );
    }
}