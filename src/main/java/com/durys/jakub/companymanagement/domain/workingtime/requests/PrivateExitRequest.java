package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import java.time.LocalDate;

public class PrivateExitRequest extends WorkingTimeRequest {

    public PrivateExitRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
                              WorkingTimeRequestPeriod period, WorkingTimeRequestStatus status) {
        super(requestId, authorId, atDay, period, status);
    }
    
}
