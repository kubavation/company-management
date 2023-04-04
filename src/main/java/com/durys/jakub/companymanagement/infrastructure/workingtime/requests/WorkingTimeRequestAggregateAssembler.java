package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output.WorkingTimeRequestEntity;
import com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output.WorkingTimeRequestStatus;
import org.springframework.stereotype.Component;

@Component
public class WorkingTimeRequestAggregateAssembler implements AggregateAssembler<WorkingTimeRequestEntity, RequestInWorkflow> {

    @Override
    public WorkingTimeRequestEntity toEntity(RequestInWorkflow aggregate) {
        return WorkingTimeRequestEntity.builder()
                .id(aggregate.request().id().value())
                .day(aggregate.request().information().atDay())
                .from(aggregate.request().information().from())
                .to(aggregate.request().information().to())
                .status(toStatus(aggregate))
                .build();
    }

    @Override
    public RequestInWorkflow toAggregate(WorkingTimeRequestEntity entity) {
        return null;
    }


    private static WorkingTimeRequestStatus toStatus(RequestInWorkflow request) {
        return switch (request) {
            case SubmittedWorkingTimeRequest ignored -> WorkingTimeRequestStatus.SUBMITTED;
            case AcceptedWorkingTimeRequest ignored -> WorkingTimeRequestStatus.ACCEPTED;
            case SentForAcceptationWorkingTimeRequest ignored -> WorkingTimeRequestStatus.SENT_FOR_ACCEPTATION;
            case CancelledWorkingTimeRequest ignored -> WorkingTimeRequestStatus.CANCELLED;
            case RejectedWorkingTimeRequest ignored -> WorkingTimeRequestStatus.REJECTED;
        };
    }
}
