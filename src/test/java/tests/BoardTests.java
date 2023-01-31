package tests;

import flow.BoardModalFlow;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base_pages.TestBasePage;

//@ExtendWith(ScreenshotExtension.class)
public class BoardTests extends TestBasePage {
    private BoardModalFlow boardModalWindow;
// TODO: Attachment annotation need explanation

    @BeforeEach
    public void precondition() {
        boardModalWindow = login().getCreateBoardModalWindow();
    }
//    @Description("Verify board creation with different visibility")
//    @ParameterizedTest
//    @ValueSource(ints = {1, 3})
//    public void createNewBoard(int visibility) {
//        Assertions.assertTrue(boardModalWindow
//                .createBoard(visibility)
//                .isBoardCreated()
//        );
//    }
    @Severity(SeverityLevel.CRITICAL)//TODO: need a little bit of explanation
    @Description("Verify close board functionality")
    @Test
    public void closeBoard() {
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .closeBoard()
                .isBoardClosed()
        );
    }

    @Description("Verify board creation functionality")
    @Test
    public void createBoard(){
        Assertions.assertTrue(boardModalWindow
                .createBoard()
                .isBoardCreated());
    }
}