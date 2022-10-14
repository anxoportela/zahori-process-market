package io.zahori.process.flows;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketHome;
import io.zahori.process.pages.MarketLogin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Login {

    public void run(TestContext testContext, CaseExecution caseExecution) {

        // Loading page objects
        MarketHome home = new MarketHome(testContext);
        MarketLogin login = new MarketLogin(testContext);

        // Retrieve case data
        Map<String, String> data = caseExecution.getCas().getDataMap();

        // Converting login field to arraylist
        List<String> loginFlags = new ArrayList<>(Arrays.asList(data.get("Login").split(",")));

        // Populating login options
        boolean doLogin = Boolean.parseBoolean(loginFlags.get(0));
        String email = loginFlags.get(1);
        String password = loginFlags.get(2);
        boolean validLogin = Boolean.parseBoolean(loginFlags.get(3));

        // Going to login page and check if it's loaded
        home.clickLogin();
        if (login.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Login page loaded");
        }

        // Do login according to parameters retrieved
        if (doLogin) {
            login.doLogin(email, password);
            if (validLogin) {
                if (login.loginOk()) {
                    testContext.logStepPassedWithScreenshot("Login OK");
                }
            } else {
                if (login.loginKo()) {
                    testContext.logStepPassedWithScreenshot("Login KO");
                }
            }
        }

    }
}
