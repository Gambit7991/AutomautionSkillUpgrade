package factories;

import com.google.common.io.Resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static String CHROME_DRIVER_PATH = Resources.getResource("chromedriver.exe").getPath();

    public static WebDriver getChromeDriver(){
        final String CHROME_DRIVER_NAME = "chromedriver.exe";
        System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }
}