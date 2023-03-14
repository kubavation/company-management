package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import lombok.NonNull;

public record SubmittedWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow {

    public SubmittedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    public SentForAcceptationWorkingTimeRequest sendTo(Employee acceptant) {
        return new SentForAcceptationWorkingTimeRequest(request, acceptant.employeeId());
    }

    public CancelledWorkingTimeRequest cancel() {
        return new CancelledWorkingTimeRequest(request);
    }
}
