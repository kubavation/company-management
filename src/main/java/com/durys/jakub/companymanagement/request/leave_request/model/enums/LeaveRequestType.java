package com.durys.jakub.companymanagement.request.leave_request.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum LeaveRequestType {
    ANNUAL("Annual leave", "AL"),
    CHILDCARE("Childcare leave", "CL");

    private final String name;
    private final String shortcut;

    public static LeaveRequestType ofShortcut(String shortcut) {
        return Stream.of(LeaveRequestType.values())
                .filter(t -> t.getShortcut().equals(shortcut))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
