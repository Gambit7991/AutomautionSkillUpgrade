package tests.home_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base_pages.TestBasePage;

public class BoardTests extends TestBasePage {

    @BeforeEach
    public void precondition(){
        homePage = login();
    }

    @Test
    public void createNewBoard() {
        logger.info("Create new board process started");
        Assertions.assertTrue(homePage
                .openCreateBoardModalWindow()
                .createBoard()
                .isBoardCreated()
                .isDisplayed()
        );
        logger.info("Create new board process finished");
    }

    @Test
    public void checkSelectedBackgroundPicture() {
        logger.info("Create new board custom background process started");
        Assertions.assertTrue(homePage
                .openCreateBoardModalWindow()
                .createBoardWithBackground()
                .isBackgroundCorrect()
        );
        logger.info("Create new board custom background process finished");
    }
}