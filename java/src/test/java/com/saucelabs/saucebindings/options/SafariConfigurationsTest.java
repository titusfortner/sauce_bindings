package com.saucelabs.saucebindings.options;

import com.saucelabs.saucebindings.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SafariConfigurationsTest {

    @Test
    public void buildsDefaultSauceOptions() {
        SauceOptions sauceOptions = SauceOptions.safari().build();

        Assert.assertEquals(Browser.SAFARI, sauceOptions.getBrowserName());
        Assert.assertEquals(SaucePlatform.MAC_CATALINA, sauceOptions.getPlatformName());
        assertEquals("latest", sauceOptions.getBrowserVersion());
    }

    @Test
    public void acceptsSafariOptionsClass() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setAutomaticProfiling(true);
        safariOptions.setCapability("UnexpectedAlertBehaviour", UnexpectedAlertBehaviour.DISMISS);

        SauceOptions sauceOptions = SauceOptions.safari(safariOptions).build();

        assertEquals(Browser.SAFARI, sauceOptions.getBrowserName());
        assertEquals(safariOptions, sauceOptions.getCapabilities());
    }

    @Test
    public void fluentOrderDoesNotMatter() {
        // Setting these in order from superclass methods to subclass to ensure proper return instances
        SauceOptions sauceOptions = SauceOptions.safari()
                .setPlatformName(SaucePlatform.MAC_HIGH_SIERRA)
                .setBrowserVersion("12")
                .setAvoidProxy()
                .build();

        assertEquals(SaucePlatform.MAC_HIGH_SIERRA, sauceOptions.getPlatformName());
        assertEquals("12", sauceOptions.getBrowserVersion());
        assertTrue(sauceOptions.sauce().getAvoidProxy());
    }

    @Test
    public void acceptsOtherW3CValues() {
        SauceOptions sauceOptions = SauceOptions.safari()
                .setAcceptInsecureCerts()
                .setPageLoadStrategy(PageLoadStrategy.EAGER)
                .setUnhandledPromptBehavior(UnhandledPromptBehavior.IGNORE)
                .setStrictFileInteractability()
                .setImplicitWaitTimeout(Duration.ofSeconds(1))
                .setPageLoadTimeout(Duration.ofSeconds(100))
                .setScriptTimeout(Duration.ofSeconds(10))
                .build();

        assertEquals(true, sauceOptions.getAcceptInsecureCerts());
        assertEquals(PageLoadStrategy.EAGER, sauceOptions.getPageLoadStrategy());
        assertEquals(UnhandledPromptBehavior.IGNORE, sauceOptions.getUnhandledPromptBehavior());
        assertEquals(true, sauceOptions.getStrictFileInteractability());
        assertEquals(Duration.ofSeconds(1), sauceOptions.getImplicitWaitTimeout());
        assertEquals(Duration.ofSeconds(100), sauceOptions.getPageLoadTimeout());
        assertEquals(Duration.ofSeconds(10), sauceOptions.getScriptTimeout());
    }

    @Test
    public void acceptsSauceLabsSettings() {
        Map<String, Object> customData = new HashMap<>();
        customData.put("foo", "foo");
        customData.put("bar", "bar");

        List<String> args = new ArrayList<>();
        args.add("--silent");
        args.add("-a");
        args.add("-q");

        Map<Prerun, Object> prerun = new HashMap<>();
        prerun.put(Prerun.EXECUTABLE, "http://url.to/your/executable.exe");
        prerun.put(Prerun.ARGS, args);
        prerun.put(Prerun.BACKGROUND, false);
        prerun.put(Prerun.TIMEOUT, 120);

        List<String> tags = new ArrayList<>();
        tags.add("Foo");
        tags.add("Bar");
        tags.add("Foobar");

        SauceOptions sauceOptions = SauceOptions.safari()
                .setAvoidProxy()
                .setBuild("Sample Build Name")
                .setName("Test name")
                .setCommandTimeout(Duration.ofSeconds(2))
                .setCustomData(customData)
                .setIdleTimeout(Duration.ofSeconds(20))
                .setMaxDuration(Duration.ofSeconds(300))
                .setParentTunnel("Mommy")
                .setPrerun(prerun)
                .setPriority(0)
                .setJobVisibility(JobVisibility.TEAM)
                .setSeleniumVersion("3.141.0")
                .disableRecordLogs()
                .disableRecordScreenshots()
                .disableRecordVideo()
                .setScreenResolution("1024x768")
                .setTags(tags)
                .setTimeZone("San Francisco")
                .setTunnelIdentifier("tunnelname")
                .disableVideoUploadOnPass()
                .build();

        assertEquals("Sample Build Name", sauceOptions.sauce().getBuild());
        assertEquals(Integer.valueOf(2), sauceOptions.sauce().getCommandTimeout());
        assertEquals(customData, sauceOptions.sauce().getCustomData());
        assertEquals(Integer.valueOf(20), sauceOptions.sauce().getIdleTimeout());
        assertEquals(Integer.valueOf(300), sauceOptions.sauce().getMaxDuration());
        assertEquals("Test name", sauceOptions.sauce().getName());
        assertEquals("Mommy", sauceOptions.sauce().getParentTunnel());
        assertEquals(prerun, sauceOptions.sauce().getPrerun());
        assertEquals(Integer.valueOf(0), sauceOptions.sauce().getPriority());
        assertEquals(JobVisibility.TEAM, sauceOptions.sauce().getJobVisibility());
        assertEquals(false, sauceOptions.sauce().getRecordLogs());
        assertEquals(false, sauceOptions.sauce().getRecordScreenshots());
        assertEquals(false, sauceOptions.sauce().getRecordVideo());
        assertEquals("3.141.0", sauceOptions.sauce().getSeleniumVersion());
        assertEquals("1024x768", sauceOptions.sauce().getScreenResolution());
        assertEquals(tags, sauceOptions.sauce().getTags());
        assertEquals("San Francisco", sauceOptions.sauce().getTimeZone());
        assertEquals("tunnelname", sauceOptions.sauce().getTunnelIdentifier());
        assertEquals(false, sauceOptions.sauce().getVideoUploadOnPass());
    }
}
