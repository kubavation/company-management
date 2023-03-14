package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class WorkingTimeRequestService {

    private final WorkingTimeRequestRepository requestRepository;

    public RequestInWorkflow load(WorkingTimeRequestId requestId, WorkingTimeRequestStatus status) {
        return WorkingTimeRequestFactory.instanceFrom(requestRepository.load(requestId), status);
    }

}
