package com.saucelabs.saucebindings.performance;

import lombok.Getter;

import java.util.Map;

@Getter
public class PerformanceResults {
    private Long load;
    private Long speedIndex;
    private Long firstInteractive;
    private Long firstVisualChange;
    private Long lastVisualChange;
    private Long firstMeaningfulPaint;
    private Long firstCPUIdle;
    private Long timeToFirstByte;
    private Long firstPaint;
    private Long estimatedInputLatency;
    private Long firstContentfulPaint;
    private Long totalBlockingTime;
    private Double score;
    private Long domContentLoaded;
    private Long cumulativeLayoutShift;
    private Long serverResponseTime;
    private Long largestContentfulPaint;

    public PerformanceResults(Map<String, Object> performance) {
        this.load = (Long) performance.get(PerformanceMetric.LOAD.getValue());
        this.speedIndex = (Long) performance.get(PerformanceMetric.SPEED_INDEX.getValue());
        this.firstInteractive = (Long) performance.get(PerformanceMetric.FIRST_INTERACTIVE.getValue());
        this.firstVisualChange = (Long) performance.get(PerformanceMetric.FIRST_VISUAL_CHANGE.getValue());
        this.lastVisualChange = (Long) performance.get(PerformanceMetric.LAST_VISUAL_CHANGE.getValue());
        this.firstMeaningfulPaint = (Long) performance.get(PerformanceMetric.FIRST_MEANINGFUL_PAINT.getValue());
        this.firstCPUIdle = (Long) performance.get(PerformanceMetric.FIRST_CPU_IDLE.getValue());
        this.timeToFirstByte = (Long) performance.get(PerformanceMetric.TIME_TO_FIRST_BYTE.getValue());
        this.firstPaint = (Long) performance.get(PerformanceMetric.FIRST_PAINT.getValue());
        this.estimatedInputLatency = (Long) performance.get(PerformanceMetric.ESTIMATED_INPUT_LATENCY.getValue());
        this.firstContentfulPaint = (Long) performance.get(PerformanceMetric.FIRST_CONTENTFUL_PAINT.getValue());
        this.totalBlockingTime = (Long) performance.get(PerformanceMetric.TOTAL_BLOCKING_TIME.getValue());
        this.domContentLoaded = (Long) performance.get(PerformanceMetric.DOM_CONTENT_LOADED.getValue());
        this.cumulativeLayoutShift = (Long) performance.get(PerformanceMetric.CUMULATIVE_LAYOUT_SHIFT.getValue());
        this.serverResponseTime = (Long) performance.get(PerformanceMetric.SERVER_RESPONSE_TIME.getValue());
        this.largestContentfulPaint = (Long) performance.get(PerformanceMetric.LARGEST_CONTENTFUL_PAINT.getValue());

        Object rawScore = performance.get(PerformanceMetric.SCORE.getValue());
        this.score = rawScore.getClass().equals(Long.class) ?  ((Long) rawScore).doubleValue() : (Double) rawScore;
    }
}
