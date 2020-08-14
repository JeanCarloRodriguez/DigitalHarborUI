package steps;

/**
 * @author Jean Carlo Rodriguez
 */

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ui.common.CommonMethods;
import ui.pages.CatalogPage;
import ui.pages.MainPage;

import static java.lang.Double.parseDouble;

public class Catalog {

    MainPage mainPage;
    CatalogPage catalogPage;

    public Catalog() {
        mainPage = new MainPage();
        catalogPage = mainPage.catalogPage;
    }

    @Given("I navigate to Best Sellers section")
    public void iNavigateToBestSellersSection() {
        mainPage.catalogPage.goToBestSellerSection();
    }

    @When("I hover over the {string} item")
    public void iHoverOverTheItem(String itemName) {
        catalogPage.hoverItem(itemName);
    }

    @Then("for a old price of {string} is shown a {string} discount")
    public void forARegularPriceOfShouldShowADiscount(String expectedOldPrice, String expectedDiscount) {

        String expectedPrice;
        double oldPrice;
        double discount;

        // Removing non needed characters
        oldPrice = parseDouble(expectedOldPrice.replace("$", ""));
        discount = parseDouble(expectedDiscount.replace("-", "").replace("%", ""));

        // Calculating Price applying the discount
        double finalPrice = oldPrice * ((100 - discount) / 100);
        expectedPrice = "$" + CommonMethods.formatToTwoDecimals(finalPrice);

        Assert.assertEquals(catalogPage.getOldPrice(), expectedOldPrice);
        Assert.assertEquals(catalogPage.getPricePercentReduction(), expectedDiscount);
        Assert.assertEquals(catalogPage.getPrice(), expectedPrice);
    }

    @When("add {string} item to Cart")
    public void addItemToCart(String itemName) {
        catalogPage.addItemToCart(itemName);
    }
}
