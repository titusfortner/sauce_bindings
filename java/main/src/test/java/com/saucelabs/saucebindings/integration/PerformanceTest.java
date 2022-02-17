package com.saucelabs.saucebindings.integration;

import com.saucelabs.saucebindings.PerformanceMetrics;
import com.saucelabs.saucebindings.SaucePerformanceException;
import com.saucelabs.saucebindings.SauceSession;
import com.saucelabs.saucebindings.options.SauceOptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PerformanceTest {
    private SauceSession session;
    private RemoteWebDriver driver;

    @Rule
    public TestName testName = new TestName();

    @After
    public void cleanUp() {
        if (session != null) {
            session.stop(true);
        }
    }

    public void setup() {
        SauceOptions sauceOptions = SauceOptions.chrome()
                .setName(testName.getMethodName())
                .setCapturePerformance()
                .build();
        session = new SauceSession(sauceOptions);
        driver = session.start();

        driver.get("https://www.saucedemo.com");
    }

    @Test(expected = SaucePerformanceException.class)
    public void invalidConfig() {
        SauceOptions sauceOptions = SauceOptions.firefox()
                .setName(testName.getMethodName())
                .build();
        session = new SauceSession(sauceOptions);
        driver = session.start();

        driver.get("https://www.saucedemo.com");

        session.performance().validate();
    }

    @Test(expected = SaucePerformanceException.class)
    public void notEnabled() {
        SauceOptions sauceOptions = SauceOptions.chrome()
                .setName(testName.getMethodName())
                .build();
        session = new SauceSession(sauceOptions);
        driver = session.start();

        driver.get("https://www.saucedemo.com");

        session.performance().validate();
    }

    @Test
    public void performanceDetails() {
        setup();

        PerformanceMetrics performanceMetrics = session.performance().getCurrentPageMetrics();
        Assert.assertTrue(performanceMetrics.getLoad() > 0);
    }
}
