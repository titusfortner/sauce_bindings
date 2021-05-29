package com.saucelabs.saucebindings.options;

import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.SystemManager;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VisualOptionsTest {
    @Test
    public void defaultsNoVisualOptions() {
        SauceOptions sauceOptions = SauceOptions.chrome().build();
        assertNull(sauceOptions.visual());
    }

    @Test
    public void createsVisualOptions() {
        SauceOptions sauceOptions = SauceOptions.chrome().setVisual().build();
        assertNotNull(sauceOptions.visual());
    }

    @Test
    public void acceptsVisualOptions() {
        Map<String, Object> diffOptions = new HashMap<>();
        diffOptions.put("structure", true);
        diffOptions.put("layout", true);
        diffOptions.put("style", true);
        diffOptions.put("content", true);
        diffOptions.put("minLayoutPosition", 4);
        diffOptions.put("minLayoutDimension", 10);

        Map<String, Object> iframesOptions = new HashMap<>();
        iframesOptions.put("maxFrames", "Infinity");

        VisualOptions visualOptions = new VisualOptions();
        visualOptions
                .setProjectName("My Project")
                .setViewportSize("1024x768")
                .setBranch("branch")
                .setBaseBranch("baseBranch")
                .setDiffOptions(diffOptions)
                .setIgnore("#some-id, .some-selector")
                .setFailOnNewStates(true)
                .setAlwaysAcceptBaseBranch(true)
                .setDisableBranchBaseline(true)
                .setScrollAndStitchScreenshots(true)
                .setDisableCORS(true)
                .setIframes(true)
                .setIframesOptions(iframesOptions);

        SauceOptions sauceOptions = SauceOptions.chrome()
                .setPlatformName(SaucePlatform.MAC_HIGH_SIERRA)
                .setBrowserVersion("68")
                .setVisualOptions(visualOptions)
                .build();

        assertEquals("My Project", sauceOptions.visual().getProjectName());
        assertEquals("1024x768", sauceOptions.visual().getViewportSize());
        assertEquals("baseBranch", sauceOptions.visual().getBaseBranch());
        assertEquals(diffOptions, sauceOptions.visual().getDiffOptions());
        assertEquals("#some-id, .some-selector", sauceOptions.visual().getIgnore());
        assertTrue(sauceOptions.visual().getFailOnNewStates());
        assertTrue(sauceOptions.visual().getAlwaysAcceptBaseBranch());
        assertTrue(sauceOptions.visual().getDisableBranchBaseline());
        assertTrue(sauceOptions.visual().getScrollAndStitchScreenshots());
        assertTrue(sauceOptions.visual().getDisableCORS());
        assertTrue(sauceOptions.visual().getIframes());
        assertEquals(iframesOptions, sauceOptions.visual().getIframesOptions());
    }

    @Test
    public void createsDefaultVisualValues() {
        SauceOptions sauceOptions = SauceOptions.chrome().setVisual().build();

        MutableCapabilities visualCapabilities = new MutableCapabilities();
        visualCapabilities.setCapability("apiKey", System.getenv("SCREENER_API_KEY"));
        visualCapabilities.setCapability("branch", SystemManager.getCurrentGitBranch());
        visualCapabilities.setCapability("projectName", sauceOptions.defaultBuildName());

        assertEquals(visualCapabilities, sauceOptions.toCapabilities().getCapability("sauce:visual"));
    }

    @Test
    public void parsesCapabilitiesFromVisualValues() {
        Map<String, Object> diffOptions = new HashMap<>();
        diffOptions.put("structure", true);
        diffOptions.put("layout", true);
        diffOptions.put("style", true);
        diffOptions.put("content", true);
        diffOptions.put("minLayoutPosition", 4);
        diffOptions.put("minLayoutDimension", 10);

        Map<String, Object> iframesOptions = new HashMap<>();
        iframesOptions.put("maxFrames", "Infinity");

        VisualOptions visualOptions = new VisualOptions();
        visualOptions
                .setProjectName("My Project")
                .setViewportSize("1024x768")
                .setBranch("branch")
                .setBaseBranch("baseBranch")
                .setDiffOptions(diffOptions)
                .setIgnore("#some-id, .some-selector")
                .setFailOnNewStates(true)
                .setAlwaysAcceptBaseBranch(true)
                .setDisableBranchBaseline(true)
                .setScrollAndStitchScreenshots(true)
                .setDisableCORS(true)
                .setIframes(true)
                .setIframesOptions(iframesOptions);

        SauceOptions sauceOptions = SauceOptions.chrome()
                .setPlatformName(SaucePlatform.MAC_HIGH_SIERRA)
                .setBrowserVersion("68")
                .setVisualOptions(visualOptions)
                .build();

        MutableCapabilities visualCapabilities = new MutableCapabilities();
        visualCapabilities.setCapability("projectName", "My Project");
        visualCapabilities.setCapability("viewportSize", "1024x768");
        visualCapabilities.setCapability("branch", "branch");
        visualCapabilities.setCapability("baseBranch", "baseBranch");
        visualCapabilities.setCapability("diffOptions", diffOptions);
        visualCapabilities.setCapability("ignore", "#some-id, .some-selector");
        visualCapabilities.setCapability("failOnNewStates", true);
        visualCapabilities.setCapability("alwaysAcceptBaseBranch", true);
        visualCapabilities.setCapability("disableBranchBaseline", true);
        visualCapabilities.setCapability("scrollAndStitchScreenshots", true);
        visualCapabilities.setCapability("disableCORS", true);
        visualCapabilities.setCapability("iframes", true);
        visualCapabilities.setCapability("iframesOptions", iframesOptions);
        visualCapabilities.setCapability("apiKey", System.getenv("SCREENER_API_KEY"));

        assertEquals(visualCapabilities, sauceOptions.toCapabilities().getCapability("sauce:visual"));
    }
}