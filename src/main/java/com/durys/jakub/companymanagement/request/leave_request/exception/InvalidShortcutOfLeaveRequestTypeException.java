package com.durys.jakub.companymanagement.request.leave_request.exception;

public class InvalidShortcutOfLeaveRequestTypeException extends RuntimeException {

    private static final String MSG = "%s is not valid shortcut of LeaveRequestType";

    public InvalidShortcutOfLeaveRequestTypeException(String shortcut) {
        super(String.format(MSG, shortcut));
    }
}
