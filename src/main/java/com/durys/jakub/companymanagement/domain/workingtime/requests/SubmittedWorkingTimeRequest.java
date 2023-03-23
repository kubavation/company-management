package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public record SubmittedWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow, WorkingTimeRequest {

    public SubmittedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    public SentForAcceptationWorkingTimeRequest sendTo(Acceptant acceptant) {
        return new SentForAcceptationWorkingTimeRequest(request, acceptant);
    }

    public CancelledWorkingTimeRequest cancel() {
        return new CancelledWorkingTimeRequest(request);
    }

    @Override
    public WorkingTimeRequestId id() {
        return request.id();
    }

    @Override
    public Author author() {
        return request.author();
    }

    @Override
    public RequestInformation information() {
        return request.information();
    }
}
