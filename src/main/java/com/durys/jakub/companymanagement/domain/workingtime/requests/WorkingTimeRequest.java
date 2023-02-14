package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;

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


    public static class WorkInProgress {
    }

    interface WithAuthor {
        WithDay author(EmployeeId employeeId);
    }

    interface WithDay {
        WithPeriodFrom at(LocalDate atDay);
    }

    interface WithPeriodFrom {
        WithPeriodTo from(LocalTime time);
    }

    interface WithPeriodTo {
        WorkInProgress to(LocalTime time);
    }
}
