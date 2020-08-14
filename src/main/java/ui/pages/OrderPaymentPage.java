package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Jean Carlo Rodriguez
 */

public class OrderPaymentPage extends BasePageObject{
    
    public OrderBottomBarPage bottomBarPage;

    @FindBy(className = "cheque")
    WebElement payByCheckButton;

    @FindBy(className = "alert-success")
    WebElement orderCompleteAlert;

    public OrderPaymentPage() {
        bottomBarPage = new OrderBottomBarPage();
    }

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(payByCheckButton));
    }

    public OrderPaymentPage clickOnPayByCheckButton() {
        payByCheckButton.click();
        return this;
    }

    public String getOrderCompleteMessage() {
        wait.until(ExpectedConditions.visibilityOf(orderCompleteAlert));
        return orderCompleteAlert.getText();
    }
}