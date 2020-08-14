package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Jean Carlo Rodriguez
 */

public class OrderSummaryPage extends BasePageObject {

    public OrderBottomBarPage bottombarPage;

    private final String inStockSpanXpath = "//a[text()='$itemName']/ancestor::tr//span[text()='In stock']";
    private final String deleteItemButtonXpath = "//td[@class='cart_description']//a[text()='$itemName']" +
            "/ancestor::tr//a[@class='cart_quantity_delete']";
    private final String itemDescriptionXpath = "//td[@class='cart_description']//a[text()='$itemName']";

    @FindBy(id = "total_price")
    WebElement totalPriceLabel;

    public OrderSummaryPage() {
        bottombarPage = new OrderBottomBarPage();
    }

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(totalPriceLabel));
    }

    public boolean isItemOnStock(String itemName) {
        WebElement inStockElement;
        inStockElement = driver.findElement(By.xpath(inStockSpanXpath.replace("$itemName", itemName)));
        return inStockElement.isDisplayed();
    }

    public void removeItemFromCart(String itemName) {
        WebElement deleteItemButton;
        deleteItemButton = driver.findElement(By.xpath(deleteItemButtonXpath.replace("$itemName", itemName)));
        deleteItemButton.click();
    }

    public boolean isItemDeletedFromShoppingCart(String itemName) {
        return isDeleted(10, By.xpath(itemDescriptionXpath.replace("$itemName", itemName)));
    }

    public String getTotalPrice() {
        return totalPriceLabel.getText();
    }
}
