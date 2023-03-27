package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.commons.events.publisher.DomainEventPublisher;
import com.durys.jakub.companymanagement.domain.workingtime.event.WorkingTimeRequestAcceptedEvent;
import com.durys.jakub.companymanagement.domain.workingtime.requests.exception.InvalidActionOnWorkingTimeRequestException;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class WorkingTimeRequestService {

    private final DomainEventPublisher eventPublisher;


    public void affectWorkingTimeSchedule(WorkingTimeRequestAcceptedEvent event) {
        eventPublisher.publish(event);
    }


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
