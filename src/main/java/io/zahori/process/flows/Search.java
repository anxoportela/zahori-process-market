package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketHome;
import io.zahori.process.pages.MarketLogin;
import io.zahori.process.pages.MarketSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Search {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Loading page objects
        MarketHome home = new MarketHome(testContext);
        MarketSearch search = new MarketSearch(testContext);

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Converting login field to arraylist
        List<String> loginFlags = new ArrayList<>(Arrays.asList(data.get("Login").split(",")));

        // Getting doLogin flag
        boolean doLogin = Boolean.parseBoolean(loginFlags.get(0));

        // Check if login is needed and do it
        if(doLogin){
            Login login = new Login();
            login.run(testContext,caseExecution);
            Home homePage = new Home();
            homePage.run(testContext, caseExecution);
        }

        // Search item
        home.writeSearchInput(data.get("ItemSearch"));
        home.clickSearchBtn();

        // Check if the results page loaded correctly
        if(search.pageLoaded()){
            testContext.logStepPassedWithScreenshot("Search result page loaded");
        }

        // Check if the correct result is displayed
        if(search.checkResults(data.get("ItemSearch"))){
            testContext.logStepPassedWithScreenshot("Search result correct");
        }

    }
}
