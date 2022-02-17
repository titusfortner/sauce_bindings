package com.saucelabs.saucebindings;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        validateParams(perf);
    }

    public void validate(PerformanceMetric metric) {
        List<PerformanceMetric> metrics = new ArrayList<>();
        metrics.add(metric);
        validate(metrics);
    }

    public void validate(List<PerformanceMetric> metrics) {
        HashMap<String, Object> perf = new HashMap<>();
        perf.put("name", testName);
        perf.put("metrics", metrics.stream().map(PerformanceMetric::getValue));

        validateParams(perf);
    }

    private void validateParams(Map<String, Object> params) {
        Map<String, Object> performance = (Map<String, Object>) driver.executeScript("sauce:performance", params);

        if (!performance.get("result").equals("pass")) {
            throw new SaucePerformanceException(performance.get("reason") + "\n" + performance.get("details"));
        }
    }

    public PerformanceResults getCurrentPageMetrics() {
        HashMap<String, Object> metricsLog = new HashMap<>();
        metricsLog.put("type", "sauce:performance");

        Map<String, Object> metrics = (Map<String, Object>) driver.executeScript("sauce:log", metricsLog);
        return new PerformanceResults(metrics);
    }

}
