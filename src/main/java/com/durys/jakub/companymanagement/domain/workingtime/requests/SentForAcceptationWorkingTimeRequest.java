package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

public class SentForAcceptationWorkingTimeRequest implements RequestInWorkflow, WorkingTimeRequest {

    private final WorkingTimeRequest request;
    private EmployeeId acceptantId;

    public SentForAcceptationWorkingTimeRequest(@NonNull WorkingTimeRequest request, @NonNull EmployeeId acceptantId) {
        this.request = request;
        this.acceptantId = acceptantId;
    }

    public SentForAcceptationWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    public AcceptedWorkingTimeRequest accept() {
        return new AcceptedWorkingTimeRequest(request);
    }

    RejectedWorkingTimeRequest markAsRejected() {
        return new RejectedWorkingTimeRequest(request);
    }

    @Override
    public WorkingTimeRequest request() {
        return request;
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

    public EmployeeId acceptantId() {
        return this.acceptantId;
    }
}
