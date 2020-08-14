package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Jean Carlo Rodriguez
 */

public class OrderShippingPage extends BasePageObject{

    public OrderBottomBarPage bottomBarPage;

    @FindBy(id = "cgv")
    WebElement toogleTermsOfServiceButton;

    @FindBy(className = "fancybox-error")
    WebElement termsOfServicesMessage;

    public OrderShippingPage() {
        bottomBarPage = new OrderBottomBarPage();
    }

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(toogleTermsOfServiceButton));
    }

    public void toogleTermsOfServicesOn() {
        if (!toogleTermsOfServiceButton.isSelected()) {
            toogleTermsOfServiceButton.click();
        }
    }
    
    public void toogleTermsOfServicesOff() {
        if (toogleTermsOfServiceButton.isSelected()) {
            toogleTermsOfServiceButton.click();
        }
    }

    public boolean isToogleTermsOfConditionSelected() {
        return toogleTermsOfServiceButton.isSelected();
    }

    public String getTermsOfServiceMessage() {
        String termsOfServiceMesage;
        wait.until(ExpectedConditions.visibilityOf(termsOfServicesMessage));
        termsOfServiceMesage = termsOfServicesMessage.getText();
        // Closing message
        driver.findElement(By.className("fancybox-item")).click();
        return termsOfServiceMesage;
    }
}