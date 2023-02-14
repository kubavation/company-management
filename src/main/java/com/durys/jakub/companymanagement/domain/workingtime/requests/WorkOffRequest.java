package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestStatus;
import com.durys.jakub.companymanagement.domain.workingtime.requests.PrivateExitRequest;

import java.time.LocalDate;

public class WorkOffRequest extends WorkingTimeRequest {

    private final PrivateExitRequest privateExitRequest;

    public WorkOffRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
                          WorkingTimeRequestPeriod period, WorkingTimeRequestStatus status, PrivateExitRequest privateExitRequest) {
        super(requestId, authorId, atDay, period, status);
        this.privateExitRequest = privateExitRequest;
    }
}
