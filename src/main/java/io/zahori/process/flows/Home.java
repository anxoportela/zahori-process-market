package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketHome;

import java.util.Map;

public class Home {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Loading page objects
        MarketHome home = new MarketHome(testContext);

        // Open homepage
        String url = caseExecution.getConfiguration().getEnvironmentUrl();
        testContext.getBrowser().loadPage(url);

        // Check if homepage is loaded
        if (home.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Page loaded");
        }

    }
}