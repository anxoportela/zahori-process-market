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

public class Cart {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects

        // Import flows
        Item itemPage = new Item();

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Search items
        itemPage.run(testContext, caseExecution);

    }
}
