package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketHome;
import io.zahori.process.pages.MarketSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Search {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects
        MarketHome home = new MarketHome(testContext);
        MarketSearch search = new MarketSearch(testContext);

        // Import flows
        Login login = new Login();

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Getting item name
        String itemName = new ArrayList<>(Arrays.asList(data.get("Item").split(","))).get(0);

        // Check if login is needed and do it
        login.run(testContext, caseExecution);

        // Search item
        home.writeSearchInput(itemName);
        home.clickSearchBtn();

        // Check if the results page loaded correctly
        if (search.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Search result page loaded correctly");
        }

        // Check if the correct result is displayed
        if (search.checkResults(itemName)) {
            testContext.logStepPassedWithScreenshot("Search result correct");
        }

    }
}
