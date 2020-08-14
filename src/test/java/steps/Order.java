package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import ui.pages.OrderPaymentPage;
import ui.pages.OrderShippingPage;
import ui.pages.OrderSummaryPage;

/**
 * @author Jean Carlo Rodriguez
 */

public class Order {

    OrderSummaryPage orderSummaryPage;
    OrderShippingPage orderShippingPage;
    OrderPaymentPage orderPaymentPage;

    public Order() {
        orderSummaryPage = new OrderSummaryPage();
        orderShippingPage = new OrderShippingPage();
        orderPaymentPage = new OrderPaymentPage();
    }

    @Then("the {string} item it's available")
    public void theItemShouldByAvailable(String itemName) {
        Assert.assertTrue(itemName + "should be in stock", orderSummaryPage.isItemOnStock(itemName));
    }

    @When("I remove {string} item from shopping cart")
    public void iRemoveItemFromShoppingCart(String itemName) {
        orderSummaryPage.removeItemFromCart(itemName);
    }

    @Then("{string} item should  be deleted from shopping cart")
    public void itemShouldBeDeletedFromShoppingCart(String itemName) {
        Assert.assertTrue("Item should by deleted", orderSummaryPage.isItemDeletedFromShoppingCart(itemName));
    }

    @And("the total amount to pay is {string}")
    public void theTotalAmountToPayIs(String totalAmount) {
        Assert.assertEquals(totalAmount, orderSummaryPage.getTotalPrice());
    }

    @Then("proceed with the checkout")
    public void proceedWithTheCheckout() {
        orderSummaryPage.bottombarPage.proceesToCheckout();
    }

    @Then("accept Shipping Terms of Services")
    public void acceptTermsOfServices() {
        orderShippingPage.toogleTermsOfServicesOn();
        Assert.assertTrue(orderShippingPage.isToogleTermsOfConditionSelected());
    }

    @And("I try to continue to checkout without accept Shipping Terms of Services")
    public void iTryToContinueToCheckoutWithoutAcceptShippingTermsOfServices() {
        orderShippingPage.toogleTermsOfServicesOff();
        Assert.assertFalse(orderShippingPage.isToogleTermsOfConditionSelected());
        orderSummaryPage.bottombarPage.proceesToCheckout();
    }

    @Then("this message {string} is displayed about to accept Shipping Terms of Service")
    public void thisMessageIsDisplayedAboutAcceptShippingTermsOfService(String expectedMessage) {
        String actualMessage = orderShippingPage.getTermsOfServiceMessage();

        Assert.assertEquals("The message is incorrect", expectedMessage, actualMessage);
    }

    @When("I choose pay By check")
    public void iChoosePyByCheck() {
        orderPaymentPage.clickOnPayByCheckButton();
    }

    @And("I confirm my order")
    public void iConfirmMyOrder() {
        orderPaymentPage.bottomBarPage.clickOnIConfirmMyOrderButton();
    }

    @Then("this message is displayed {string} about the order was completed")
    public void thisMessageIsDisplayedAboutTheOrderWasCompleted(String expectedMessage) {
        String actualMessage = orderPaymentPage.getOrderCompleteMessage();
        Assert.assertEquals("The message is incorrect", expectedMessage, actualMessage);
    }
}
