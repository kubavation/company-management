package com.durys.jakub.companymanagement.shared.enums;

public enum Status {

    ACTIVE("A"),
    DELETED("X");

    private final String shortcut;

    Status(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }
}
