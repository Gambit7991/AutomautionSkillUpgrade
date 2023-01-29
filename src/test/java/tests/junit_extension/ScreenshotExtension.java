package tests.junit_extension;

import ch.qos.logback.classic.Logger;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class ScreenshotExtension implements AfterTestExecutionCallback {
    public static WebDriver driver;
    public final Logger logger
            = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback.tests");


    public static void setDriver(WebDriver driver){
        ScreenshotExtension.driver = driver;
    }
    @Attachment(value = "{testName} - screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure(String testName) {
        logger.info(testName + " -> working on screenshot...");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        logger.info("afterTestExecution");
        Method method = extensionContext.getRequiredTestMethod();
        if (extensionContext.getExecutionException().isPresent()) {
            makeScreenshotOnFailure(method.getName());
        }
    }
}
