package com.durys.jakub.companymanagement.shared.enums;

import java.util.stream.Stream;

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

    public static Status of(String shortcut) {
        return Stream.of(Status.values())
                .filter(s -> s.getShortcut().equals(shortcut))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
