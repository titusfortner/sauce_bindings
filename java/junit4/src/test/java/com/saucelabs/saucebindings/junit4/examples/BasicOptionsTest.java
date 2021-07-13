package com.saucelabs.saucebindings.junit4.examples;

import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.UnhandledPromptBehavior;
import com.saucelabs.saucebindings.junit4.SauceBaseTest;
import com.saucelabs.saucebindings.options.SauceOptions;
import org.junit.Test;

// 1. Have your test class extend the `SauceBaseTest` class
public class BasicOptionsTest extends SauceBaseTest {

    // 2. Create SauceOptions instance with static browser method and build()
    @Override
    public SauceOptions createSauceOptions() {
        return SauceOptions.firefox()
                .setUnhandledPromptBehavior(UnhandledPromptBehavior.IGNORE)
                .setPlatformName(SaucePlatform.MAC_MOJAVE)
                .build();
    }

    @Test
    public void startSession() {
        // 3. The superclass automatically creates the session and the driver

        // 4. Use the driver in your tests just like normal
        driver.get("https://www.saucedemo.com/");

        // 5. The superclass automatically stops the session and reports results
    }
}
