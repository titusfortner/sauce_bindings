package com.saucelabs.saucebindings.junit4.examples;

import com.saucelabs.saucebindings.junit4.SauceBaseTest;
import org.junit.Test;

// 1. Have your test class extend the `SauceBaseTest` class
public class SessionTest extends SauceBaseTest {

    @Test
    public void startSession() {
        // 2. The superclass automatically creates the session and the driver

        // 3. Use the driver in your tests just like normal
        driver.get("https://www.saucedemo.com/");

        // 4. The superclass automatically stops the session and reports results
    }
}
