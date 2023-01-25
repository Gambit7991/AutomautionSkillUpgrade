package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.base_pages.TestBasePage;

public class LoginTests extends TestBasePage {

    @Test
    public void loginTest() {
        logger.info("Login process started");
        Assertions.assertTrue(login()
                .isSignedIn()
        );
        logger.info("Login process finished");
    }
}