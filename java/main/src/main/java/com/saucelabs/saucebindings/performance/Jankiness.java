package com.saucelabs.saucebindings.performance;

import lombok.Getter;

import java.util.Map;

@Getter
public class Jankiness {
    private final String url;
    private final Map<String, Object> metrics;
    private final Map<String, Object> diagnostics;
    private final Double score;
    private final String type;

    public Jankiness(Map<String, Object> jankiness) {
        this.url = (String) jankiness.get("url");
        this.metrics = (Map<String, Object>) jankiness.get("metrics");
        this.diagnostics = (Map<String, Object>) jankiness.get("diagnostics");
        this.score = (Double) jankiness.get("score");
        this.type = (String) jankiness.get("type");
    }
}
