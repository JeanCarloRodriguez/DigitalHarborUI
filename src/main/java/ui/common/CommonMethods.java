package ui.common;

/**
 * @author Jean Carlo Rodriguez
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Locale;

public class CommonMethods {

    /**
     * Hover an element in the UI
     *
     * @param driver  a WebDriver isntance
     * @param element a WebElement that wants to hovered
     */
    public static void mouseHover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * Format a double to two decimals e.g. 20.50
     *
     * @param number is the double that wants to be formatted
     * @return a String with 2 decimals formatted
     */
    public static String formatToTwoDecimals(double number) {
        return String.format(Locale.US, "%.2f", number);
    }
}
