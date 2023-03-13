package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import lombok.NonNull;

public class SubmittedWorkingTimeRequest implements RequestInWorkflow {

    private final WorkingTimeRequest request;

    public SubmittedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    public SentForAcceptationWorkingTimeRequest sendTo(Employee acceptant) {
        return new SentForAcceptationWorkingTimeRequest(request, acceptant.employeeId());
    }

    public CancelledWorkingTimeRequest cancel() {
        return new CancelledWorkingTimeRequest(request);
    }


    @Override
    public WorkingTimeRequest request() {
        return null;
    }
}
