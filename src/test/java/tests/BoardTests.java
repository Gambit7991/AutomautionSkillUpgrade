package tests;

import io.qameta.allure.Step;
import modal_windows.CreateBoardModalWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base_pages.TestBasePage;

import java.io.IOException;

public class BoardTests extends TestBasePage {
    private CreateBoardModalWindow boardModalWindow;

    @Step("Open modal window to create new board")
    @BeforeEach
    public void precondition() {
        boardModalWindow = login().openCreateBoardModalWindow();
    }

    @Step("Create new board test started")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    public void createNewBoard(int visibility) throws IOException {
        Assertions.assertTrue(boardModalWindow
                .createBoard(visibility)
                .isBoardCreated()
        );
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

    @Step("Close board test started")
    @Test
    //TODO : Что лучше, создавать доску и удалять ее потом или только удалять
    public void closeBoard() {
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .closeBoard()
                .isBoardClosed()
        );
    }
}