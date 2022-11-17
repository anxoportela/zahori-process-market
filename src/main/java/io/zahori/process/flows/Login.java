package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.HomePage;

import java.util.Map;

public class Login {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Import page objects
        HomePage home = new HomePage(testContext);

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Open homepage
        String url = caseExecution.getConfiguration().getEnvironmentUrl();
        testContext.getBrowser().loadPage(url);

        // Check if homepage is loaded
        if (home.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Home page loaded correctly");
        } else {
            testContext.logStepFailed("Home Page not loaded");
        }

        home.doLogin(data.get("Username"), data.get("Password"), data.get("UserType"));

        if (!data.get("UserType").equals("valid")){
            testContext.logStepPassedWithScreenshot("Incorrect Login");
        } else {
            testContext.logStepPassedWithScreenshot("Correct Login");
        }

    }
}
