package com.durys.jakub.companymanagement.domain.workingtime.requests.privateexit;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestPeriod;

import java.time.LocalDate;

public class PrivateExitRequest extends WorkingTimeRequest {

    public PrivateExitRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay, WorkingTimeRequestPeriod period) {
        super(requestId, authorId, atDay, period);
    }
}
