package com.durys.jakub.companymanagement.domain.workingtime.requests.workoff;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestType;
import com.durys.jakub.companymanagement.domain.workingtime.requests.privateexit.PrivateExitRequest;

import java.time.LocalDate;

public class WorkOffRequest extends WorkingTimeRequest {

    private PrivateExitRequest privateExitRequest;

    public WorkOffRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
                          WorkingTimeRequestPeriod period, WorkingTimeRequestType type, PrivateExitRequest privateExitRequest) {
        super(requestId, authorId, atDay, period, type);
        this.privateExitRequest = privateExitRequest;
    }
}
