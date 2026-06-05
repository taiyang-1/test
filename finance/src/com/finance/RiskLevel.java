package com.finance;

public enum RiskLevel {
    LOW("低风险"), MEDIUM("中等风险"), HIGH("高风险");
    private final String displayName;
    RiskLevel(String displayName) {
        this.displayName = displayName;
    }
    public String getDescription() {
        return displayName;
    }
}
