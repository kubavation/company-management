package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

public record SubmittedWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow, WorkingTimeRequest {

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
    public WorkingTimeRequestId id() {
        return request.id();
    }

    @Override
    public EmployeeId authorId() {
        return request.authorId();
    }

    @Override
    public RequestInformation information() {
        return request.information();
    }
}
