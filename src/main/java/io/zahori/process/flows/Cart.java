package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.CartPage;

import java.util.Map;

public class Cart {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects
        CartPage cart = new CartPage(testContext);

        // Import flows
        Item itemPage = new Item();

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Realize item operations
        itemPage.run(testContext, caseExecution);

        // Check if cart page loaded correctly
        if (cart.checkHeader()){
            testContext.logStepPassedWithScreenshot("Cart page loaded correctly");
        } else {
            testContext.logStepFailed("Cart page not loaded");
        }

    }
}
