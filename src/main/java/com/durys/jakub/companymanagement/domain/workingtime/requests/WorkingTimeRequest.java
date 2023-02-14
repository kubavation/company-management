package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;

public abstract class WorkingTimeRequest {
    private final WorkingTimeRequestId requestId;
    private final EmployeeId authorId;
    private final LocalDate atDay;
    private final WorkingTimeRequestPeriod period;
    private WorkingTimeRequestStatus status;

    public WorkingTimeRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
                              WorkingTimeRequestPeriod period, WorkingTimeRequestStatus status) {
        this.requestId = requestId;
        this.authorId = authorId;
        this.atDay = atDay;
        this.period = period;
        this.status = status;
    }
}
