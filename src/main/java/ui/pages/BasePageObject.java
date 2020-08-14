package ui.pages;

/**
 * @author Jean Carlo Rodriguez
 */

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the web driver, wait and web elements
     */
    public BasePageObject() {
        this.driver = DriverManager.getInstance().getWebDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    /**
     * Choose an element that laods last on the page to verify the page is fully loaded
     */
    public abstract void waitUntilPageIsLoaded();

    /**
     * the isPresent method returns true if the element By is present
     * otherwise return false
     */
    public boolean isPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * the isDeleted method return true if the Item was deleted otherwise return false
     */
    public boolean isDeleted(int numberOfTries, By by) {
        boolean isDeleted = false;
        int count = 0;
        while (count != numberOfTries) {
            count++;
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Sleep fails: " + e);
            }

            if (!isPresent(by)) {
                isDeleted = true;
                count = numberOfTries;
            }
        }
        return isDeleted;
    }
}