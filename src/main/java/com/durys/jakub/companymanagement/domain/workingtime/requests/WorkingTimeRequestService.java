package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.workingtime.requests.exception.InvalidActionOnWorkingTimeRequestException;

@DomainService
public class WorkingTimeRequestService {


    public static SubmittedWorkingTimeRequest asSendable(RequestInWorkflow request) {

        if (!(request instanceof SubmittedWorkingTimeRequest submittedRequest)) {
            throw new InvalidActionOnWorkingTimeRequestException();
        }

        return submittedRequest;
    }

    public static SentForAcceptationWorkingTimeRequest asAcceptable(RequestInWorkflow request) {

        if (!(request instanceof SentForAcceptationWorkingTimeRequest sentRequest)) {
            throw new InvalidActionOnWorkingTimeRequestException();
        }

        return sentRequest;
    }

    public static SentForAcceptationWorkingTimeRequest asRejectable(RequestInWorkflow request) {

        if (!(request instanceof SentForAcceptationWorkingTimeRequest rejectableRequest)) {
            throw new InvalidActionOnWorkingTimeRequestException();
        }

        return rejectableRequest;
    }

    public static RequestInWorkflow asCancelable(RequestInWorkflow request) {
        if (request instanceof AcceptedWorkingTimeRequest) {
            throw new InvalidActionOnWorkingTimeRequestException();
        }

        return request;
    }

}
