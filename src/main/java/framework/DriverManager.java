package framework;

/**
 * @author Jean Carlo Rodriguez
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager instance;
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
            if (wait == null) {
                wait = new WebDriverWait(driver, 20);
            }

        }
        return instance;
    }

    /**
     * get a Wait instance
     *
     * @return a WebDriverWait instance
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * get the WebDriver instance
     *
     * @return a WebDriver instance
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Quit the web explorer and remove the driver instance
     */
    public void quit() {
        driver.quit();
        driver = null;
        instance = null;
    }
}
