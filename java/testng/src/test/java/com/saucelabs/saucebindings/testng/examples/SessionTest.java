package com.saucelabs.saucebindings.testng.examples;

import com.saucelabs.saucebindings.testng.SauceBaseTest;
import org.junit.Test;

// 1. Have your test class extend the `SauceBaseTest` class
public class SessionTest extends SauceBaseTest {

    @Test
    public void startSession() {
        // 2. The superclass automatically creates the session and the driver

        // 3. Use the driver in your tests just like normal
        // Note that for thread safety, you need to use `getDriver()` instead of just `driver`
        getDriver().get("https://www.saucedemo.com/");

        // 4. The superclass automatically stops the session and reports results
    }
}
