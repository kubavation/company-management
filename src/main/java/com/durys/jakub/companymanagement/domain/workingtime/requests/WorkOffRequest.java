package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;

public class WorkOffRequest extends WorkingTimeRequest {

    private final PrivateExitRequest privateExitRequest;

    public WorkOffRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
                          WorkingTimeRequestPeriod period, WorkingTimeRequestStatus status, PrivateExitRequest privateExitRequest) {
        super(requestId, authorId, atDay, period, status);
        this.privateExitRequest = privateExitRequest;
    }
    
}
