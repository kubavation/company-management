package com.durys.jakub.companymanagement.domain.workingtime.exception;

public class WorkDayEventAlreadyAssignedInPeriodException extends RuntimeException {

    public WorkDayEventAlreadyAssignedInPeriodException() {
        super("Work day event already present in this period");
    }
}
