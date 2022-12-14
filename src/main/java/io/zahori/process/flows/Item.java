package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.ItemsPage;

public class Item {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects
        ItemsPage item = new ItemsPage(testContext);

        // Import flows
        Login login = new Login();

        // Login on the webpage
        login.run(testContext, caseExecution);

        // Check items header
        if (item.checkHeader()){
            testContext.logStepPassedWithScreenshot("Item page loaded correctly");
        } else {
            testContext.logStepFailed("Item page not loaded");
        }

        // Add random item to cart
        item.selectItem();

        // Check item added correctly
        if (item.checkCartItems()){
            testContext.logStepPassedWithScreenshot("Added random item to cart");
        } else {
            testContext.logStepFailed("Item not added to cart");
        }

        item.clickCartBtn();


    }
}
