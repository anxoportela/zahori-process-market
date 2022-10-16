package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketCart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cart {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects
        MarketCart cart = new MarketCart(testContext);

        // Import flows
        Item itemPage = new Item();

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Converting cart field to arraylist
        List<String> cartSetup = new ArrayList<>(Arrays.asList(data.get("Cart").split(",")));

        // Populating cart options
        int incQ = Integer.parseInt(cartSetup.get(0));
        int decQ = Integer.parseInt(cartSetup.get(1));
        int wriQ = Integer.parseInt(cartSetup.get(2));
        boolean delItem = Boolean.parseBoolean(cartSetup.get(3));
        boolean goCheckout = Boolean.parseBoolean(cartSetup.get(4));

        // Realize item operations
        itemPage.run(testContext, caseExecution);

        // Check if cart page loaded correctly
        if (cart.pageLoaded()){
            testContext.logStepPassedWithScreenshot("Cart page loaded correctly");
        } else {
            testContext.logStepFailedWithScreenshot("Cart page not loaded");
        }

        // Add n quantity to item
        if (incQ > 0) {
            cart.addQuantity(incQ);
            testContext.logStepPassedWithScreenshot("Added " + incQ + " to item quantity");
        }

        // Remove n quantity from item
        if (decQ > 0) {
            cart.rmQuantity(decQ);
            testContext.logStepPassedWithScreenshot("Removed " + decQ + " from item quantity");
        }

        // Write n value to quantity input
        if (wriQ > 0) {
            cart.inputQuantity(wriQ);
            testContext.logStepPassedWithScreenshot("Wrote " + wriQ + " to item quantity input");
        }

        // Remove item from cart
        if (delItem) {
            cart.rmItem();
            testContext.logStepPassedWithScreenshot("Item deleted from cart");
        }

        // Go to check out or return to webpage
        if (goCheckout) {
            cart.clickCheckout();
        } else {
            cart.clickReturnShop();
        }

    }
}
