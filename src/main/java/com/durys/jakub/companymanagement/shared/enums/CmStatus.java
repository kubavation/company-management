package com.durys.jakub.companymanagement.shared.enums;

import java.util.stream.Stream;

public enum CmStatus {

    ACTIVE("A"),
    DELETED("X");

    private final String shortcut;

    CmStatus(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public static CmStatus of(String shortcut) {
        return Stream.of(CmStatus.values())
                .filter(s -> s.getShortcut().equals(shortcut))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
