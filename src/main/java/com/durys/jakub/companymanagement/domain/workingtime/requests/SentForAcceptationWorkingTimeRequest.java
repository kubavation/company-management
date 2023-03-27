package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public record SentForAcceptationWorkingTimeRequest(WorkingTimeRequest request,
                                                   Acceptant acceptant) implements RequestInWorkflow, WorkingTimeRequest {

    public SentForAcceptationWorkingTimeRequest(@NonNull WorkingTimeRequest request, @NonNull Acceptant acceptant) {
        this.request = request;
        this.acceptant = acceptant;
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
