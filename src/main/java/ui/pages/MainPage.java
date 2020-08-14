package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.common.CommonMethods;

/**
 * @author Jean Carlo Rodriguez
 */
public class MainPage extends BasePageObject {

    public CatalogPage catalogPage;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement showCartDropdown;

    @FindBy(id = "button_order_cart")
    private WebElement checkoutCartButton;

    public MainPage() {
        catalogPage = new CatalogPage();
    }

    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(showCartDropdown));
    }

    public OrderSummaryPage clickOnCheckoutShowCart() {
        CommonMethods.mouseHover(driver, showCartDropdown);
        checkoutCartButton.click();
        return new OrderSummaryPage();
    }
}
