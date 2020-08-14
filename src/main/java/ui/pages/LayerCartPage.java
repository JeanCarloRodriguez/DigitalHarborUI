package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Jean Carlo Rodriguez
 */

public class LayerCartPage extends BasePageObject {

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    private WebElement continueShoppingButton;

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
    }

    public MainPage clickOnContinueShoppingButton() {
        continueShoppingButton.click();
        return new MainPage();
    }
}
