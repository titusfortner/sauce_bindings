package com.saucelabs.saucebindings.testng.examples;

import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.UnhandledPromptBehavior;
import com.saucelabs.saucebindings.options.SauceOptions;
import com.saucelabs.saucebindings.testng.SauceBaseTest;
import org.junit.Test;

// 1. Have your test class extend the `SauceBaseTest` class
public class BasicOptionsTest extends SauceBaseTest {

    // 2. Create SauceOptions instance with static browser method and build()
    public SauceOptions createSauceOptions() {
        return SauceOptions.firefox()
                .setUnhandledPromptBehavior(UnhandledPromptBehavior.IGNORE)
                .setPlatformName(SaucePlatform.MAC_MOJAVE)
                .build();
    }

    @Test
    public void basicOptions() {
        // 3. The superclass automatically creates the session and the driver

        // 4. Use the driver in your tests just like normal
        // Note that for thread safety, you need to use `getDriver()` instead of just `driver`
        getDriver().get("https://www.saucedemo.com/");

        // 5. The superclass automatically stops the session and reports results
    }
}
