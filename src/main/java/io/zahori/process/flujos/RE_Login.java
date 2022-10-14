package io.zahori.process.flujos;

import io.zahori.framework.core.TestContext;
import io.zahori.model.process.CaseExecution;
import io.zahori.process.pages.MarketHome;
import io.zahori.process.pages.MarketLogin;

import java.util.Map;

public class RE_Login {

    public void run(TestContext testContext, CaseExecution caseExecution) {
        Map<String, String> data = caseExecution.getCas().getDataMap();
        MarketHome home = new MarketHome(testContext);
        MarketLogin login = new MarketLogin(testContext);
        String url = caseExecution.getConfiguration().getEnvironmentUrl();
        testContext.getBrowser().loadPage(url);
        if (home.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Page loaded");
        }
        home.clickLogin();
        if (login.pageLoaded()) {
            testContext.logStepPassedWithScreenshot("Login page loaded");
        }
        login.doLogin(data.get("Email"), data.get("Password"));
        if (login.loginOk()) {
            testContext.logStepPassedWithScreenshot("Login OK");
        }
    }
}
