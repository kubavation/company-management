package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.Employee;

import java.util.UUID;

public record Author(UUID authorId) {

    public SubmittedWorkingTimeRequest submit(WorkInProgress submittable) {
        return new SubmittedWorkingTimeRequest(WorkingTimeRequestFactory.instanceFrom(submittable));
    }

    public CancelledWorkingTimeRequest cancel(RequestInWorkflow requestInWorkflow) {

        RequestInWorkflow cancelable = WorkingTimeRequestService.asCancelable(requestInWorkflow);

        return new CancelledWorkingTimeRequest(cancelable.request());
    }

    public SubmittedWorkingTimeRequest.NeedsAcceptant send(SubmittedWorkingTimeRequest request) {
        return request.needsAcceptant();
    }

    public static Author from(Employee employee) {
        return new Author(employee.employeeId().value());
    }



}
