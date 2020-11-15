package com.saucelabs.saucebindings.examples;

import com.saucelabs.saucebindings.*;
import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.options.SauceOptionsFactory;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceSpecificOptions {

    @Test
    public void sauceOptions() {
        // 1. Specify Sauce Specific Options
        SauceOptions sauceOptions = SauceOptionsFactory.chrome()
                .sauce().setExtendedDebugging(true)
                        .setIdleTimeout(100)
                        .setTimeZone("Alaska")
                        .build()
                .build();

        // 2. Create Session object with the Options object instance
        SauceSession session = new SauceSession(sauceOptions);

        // 3. Start Session to get the Driver
        RemoteWebDriver driver = session.start();

        // 4. Use the driver in your tests just like normal
        driver.get("https://www.saucedemo.com/");

        // 5. Stop the Session with whether the test passed or failed
        session.stop(true);
    }
}
