package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public abstract class WorkingTimeRequest {
    private final WorkingTimeRequestId requestId;
    private final EmployeeId authorId;
    private final LocalDate atDay;
    private final WorkingTimeRequestPeriod period;
    private final WorkingTimeRequestType type;
}
