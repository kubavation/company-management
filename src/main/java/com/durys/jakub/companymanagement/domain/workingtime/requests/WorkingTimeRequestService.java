package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;

@DomainService
public class WorkingTimeRequestService {

    public static SentForAcceptationWorkingTimeRequest asAcceptable(RequestInWorkflow request) {

        if (!(request instanceof SentForAcceptationWorkingTimeRequest sentRequest)) {
            throw new UnsupportedOperationException();
        }

        return sentRequest;
    }

    public static SentForAcceptationWorkingTimeRequest asRejectable(RequestInWorkflow request) {

        if (!(request instanceof SentForAcceptationWorkingTimeRequest rejectableRequest)) {
            throw new UnsupportedOperationException();
        }

        return rejectableRequest;
    }

}
