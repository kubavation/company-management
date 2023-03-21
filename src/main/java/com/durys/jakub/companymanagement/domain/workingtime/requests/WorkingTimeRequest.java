package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

public interface WorkingTimeRequest {
    WorkingTimeRequestId id();
    EmployeeId authorId();
    RequestInformation information();
}
