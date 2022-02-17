package com.saucelabs.saucebindings.performance;

import lombok.Getter;

public enum PerformanceMetric {
    LOAD("load"),
    SPEED_INDEX("speedIndex"),
    FIRST_INTERACTIVE("firstInteractive"),
    FIRST_VISUAL_CHANGE("firstVisualChange"),
    LAST_VISUAL_CHANGE("lastVisualChange"),
    FIRST_MEANINGFUL_PAINT("firstMeaningfulPaint"),
    FIRST_CPU_IDLE("firstCPUIdle"),
    TIME_TO_FIRST_BYTE("timeToFirstByte"),
    FIRST_PAINT("firstPaint"),
    ESTIMATED_INPUT_LATENCY("estimatedInputLatency"),
    FIRST_CONTENTFUL_PAINT("firstContentfulPaint"),
    TOTAL_BLOCKING_TIME("totalBlockingTime"),
    SCORE("score"),
    DOM_CONTENT_LOADED("domContentLoaded"),
    CUMULATIVE_LAYOUT_SHIFT("cumulativeLayoutShift"),
    SERVER_RESPONSE_TIME("serverResponseTime"),
    LARGEST_CONTENTFUL_PAINT("largestContentfulPaint");

    @Getter private final String value;

    PerformanceMetric(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
