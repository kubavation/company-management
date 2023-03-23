package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;


public record SubmittedWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow, WorkingTimeRequest {

    public SubmittedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    WithAcceptant send() {
        return new WithAcceptant();
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


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class WithAcceptant {

        public SentForAcceptationWorkingTimeRequest to(Acceptant acceptant) {
            return new SentForAcceptationWorkingTimeRequest(request, acceptant);
        }
    }
}
