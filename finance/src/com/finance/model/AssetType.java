package com.finance.model;

public enum AssetType {
    STOCK("股票"), FUND("基金"), BOND("债券");
    private final String displayName;

    AssetType(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return displayName;
    }
}
