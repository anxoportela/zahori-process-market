package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketCart;
import io.zahori.process.pages.MarketItem;
import io.zahori.process.pages.MarketSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Item {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects
        MarketSearch search = new MarketSearch(testContext);
        MarketItem item = new MarketItem(testContext);
        MarketCart cart = new MarketCart(testContext);

        // Import flows
        Search searchPage = new Search();

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Converting item field to arraylist
        List<String> itemSetup = new ArrayList<>(Arrays.asList(data.get("Item").split(",")));

        // Populating item options
        String itemName = itemSetup.get(0);
        String itemSize = itemSetup.get(1);
        int itemCount = Integer.parseInt(itemSetup.get(2));
        boolean goCheckout = Boolean.parseBoolean(itemSetup.get(3));

        // Search items
        searchPage.run(testContext, caseExecution);

        // Click on item and check that item page load correctly
        search.clickResult(itemName);
        if (item.pageLoaded()){
            testContext.logStepPassedWithScreenshot("Item page loaded correctly");
        } else {
            testContext.logStepFailedWithScreenshot("Item page not loaded");
        }

        // Add n items to cart
        if (itemCount > 0){
            item.addItems(itemCount);
            testContext.logStepPassedWithScreenshot("Changed item quantity");
        }

        // Select size
        item.changeSize(itemSize);
        testContext.logStepPassedWithScreenshot("Changed item size");

        // Add item to cart
        item.clickAddCart();
        if (item.checkItemAdded()){
            testContext.logStepPassedWithScreenshot("Item added to the cart correctly");
        } else {
            testContext.logStepFailedWithScreenshot("Error adding item to cart");
        }

        // Go to checkout page or return to item page
        if (goCheckout) {
            item.continueCheckout();
        } else {
            item.continueShop();
            if (item.pageLoaded()){
                testContext.logStepPassedWithScreenshot("Returned to item page correctly");
            } else {
                testContext.logStepFailedWithScreenshot("Error returning to item page");
            }
        }

    }
}
