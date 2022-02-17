package com.saucelabs.saucebindings;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class Performance {
    private RemoteWebDriver driver;
    private String testName;

    public Performance(RemoteWebDriver driver, String testName) {
        this.testName = testName;
        this.driver = driver;
    }

    public void validate() {
        HashMap<String, Object> perf = new HashMap<>();
        perf.put("name", testName);
        Map<String, Object> performance = (Map<String, Object>) driver.executeScript("sauce:performance", perf);

        if (!performance.get("result").equals("pass")) {
            throw new SaucePerformanceException(performance.get("reason") + "\n" + performance.get("details"));
        }
    }

    public PerformanceMetrics getCurrentPageMetrics() {
        HashMap<String, Object> metricsLog = new HashMap<>();
        metricsLog.put("type", "sauce:performance");

        Map<String, Object> metrics = (Map<String, Object>) driver.executeScript("sauce:log", metricsLog);
        return new PerformanceMetrics(metrics);
    }

}
