package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Jean Carlo Rodriguez
 */

public class OrderBottomBarPage extends BasePageObject{
    @FindBy(xpath = "//p[contains(@class,'cart_navigation')]//span")
    WebElement proceedCheckoutButton;

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(proceedCheckoutButton));
    }

    public void proceesToCheckout() {
        proceedCheckoutButton.click();
    }

    public void clickOnIConfirmMyOrderButton() {
        // proceedCheckout and confirm my order buttons are the same
        proceedCheckoutButton.click();
    }
}