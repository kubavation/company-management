package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class WorkingTimeRequestService {

    private final WorkingTimeRequestRepository requestRepository;


    public static SentForAcceptationWorkingTimeRequest asAcceptable(RequestInWorkflow request) {

        if (!(request instanceof SentForAcceptationWorkingTimeRequest sentRequest)) {
            throw new UnsupportedOperationException();
        }

        return sentRequest;
    }

}
