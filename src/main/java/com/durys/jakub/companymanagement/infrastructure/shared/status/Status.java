package com.durys.jakub.companymanagement.infrastructure.shared.status;

public enum Status {
    ACTIVE("A"),
    DELETED("D");

    private final String shortcut;

    Status(String shortcut) {
        this.shortcut = shortcut;
    }

    public String shortcut() {
        return shortcut;
    }
}
