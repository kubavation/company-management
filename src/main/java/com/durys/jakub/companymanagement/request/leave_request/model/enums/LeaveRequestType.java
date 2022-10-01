package com.durys.jakub.companymanagement.request.leave_request.model.enums;

import com.durys.jakub.companymanagement.request.leave_request.exception.InvalidShortcutOfLeaveRequestTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum LeaveRequestType {
    AL("Annual leave", "AL"),
    CL("Childcare leave", "CL");

    private final String name;
    private final String shortcut;

    public static LeaveRequestType ofShortcut(String shortcut) {

        return Stream.of(LeaveRequestType.values())
                .filter(t -> t.getShortcut().equals(shortcut))
                .findFirst()
                .orElseThrow(() -> new InvalidShortcutOfLeaveRequestTypeException(shortcut));
    }

}
