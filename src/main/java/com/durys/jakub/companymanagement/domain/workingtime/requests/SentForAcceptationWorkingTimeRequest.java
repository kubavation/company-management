package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

public class SentForAcceptationWorkingTimeRequest {

    private final WorkingTimeRequest request;
    private final EmployeeId acceptantId;

    public SentForAcceptationWorkingTimeRequest(@NonNull WorkingTimeRequest request, @NonNull EmployeeId acceptantId) {
        this.request = request;
        this.acceptantId = acceptantId;
    }
}
