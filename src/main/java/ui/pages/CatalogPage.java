package ui.pages;

/**
 * @author Jean Carlo Rodriguez
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.common.CommonMethods;

public class CatalogPage extends BasePageObject {

    @FindBy(className = "blockbestsellers")
    private WebElement bestSellerSectionButton;

    // Xpath used to get element that is hover
    private final String hoverPriceContainerXpath = "//li[contains(@class,'hovered')]//div[@class='left-block']//div[@class='content_price']";

    @FindBy(xpath = hoverPriceContainerXpath + "/span[@class='price product-price']")
    private WebElement priceSpan;

    @FindBy(xpath = hoverPriceContainerXpath + "/span[@class='old-price product-price']")
    private WebElement oldPriceSpan;

    @FindBy(xpath = hoverPriceContainerXpath + "/span[@class='price-percent-reduction']")
    private WebElement pricePercentReductionSpan;

    @FindBy(xpath = "//li[contains(@class,'hovered')]//a[@title=\"Add to cart\"]")
    private WebElement addToCartButton;

    //Xpath used to get any item in BestSellers section using the Item Name
    private String bestSellersItemXpath = "//ul[@id='blockbestsellers']//a[contains(text(),'$itemName')]";


    public CatalogPage() {
        waitUntilPageIsLoaded();
    }

    @Override
    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(bestSellerSectionButton));
    }

    public void goToBestSellerSection() {
        bestSellerSectionButton.click();
    }

    public void hoverItem(String itemName) {
        WebElement itemImgContainer;
        itemImgContainer = driver.findElement(By.xpath(bestSellersItemXpath.replace("$itemName", itemName)));
        CommonMethods.mouseHover(driver, itemImgContainer);
    }

    public String getOldPrice() {
        return oldPriceSpan.getText();
    }

    public String getPrice() {
        return priceSpan.getText();
    }

    public String getPricePercentReduction() {
        return pricePercentReductionSpan.getText();
    }

    public void addItemToCart(String itemName) {
        hoverItem(itemName);
        LayerCartPage layerCartPage = clickOnAddToCartButton();
        layerCartPage.clickOnContinueShoppingButton();
    }

    private LayerCartPage clickOnAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return new LayerCartPage();
    }
}
