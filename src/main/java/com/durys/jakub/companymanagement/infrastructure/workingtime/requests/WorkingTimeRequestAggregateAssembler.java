package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.RequestInformation;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output.WorkingTimeRequestEntity;
import com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output.WorkingTimeRequestStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
        var request = switch (entity.getType()) {
            case PRIVATE_EXIT -> new PrivateExitRequest(
                    new WorkingTimeRequestId(entity.getId()),
                    new Author(UUID.fromString(entity.getEmployee().getDomainId())),
                    new RequestInformation(entity.getDay(), entity.getFrom(), entity.getTo()));
            case WORK_OFF -> new WorkOffRequest(
                    new WorkingTimeRequestId(entity.getId()),
                    new Author(UUID.fromString(entity.getEmployee().getDomainId())),
                    new RequestInformation(entity.getDay(), entity.getFrom(), entity.getTo()));
            case OVERTIME -> new OvertimeRequest(
                    new WorkingTimeRequestId(entity.getId()),
                    new Author(UUID.fromString(entity.getEmployee().getDomainId())),
                    new RequestInformation(entity.getDay(), entity.getFrom(), entity.getTo()));
            case OVERTIME_TAKEN -> new OvertimeTakenRequest(
                    new WorkingTimeRequestId(entity.getId()),
                    new Author(UUID.fromString(entity.getEmployee().getDomainId())),
                    new RequestInformation(entity.getDay(), entity.getFrom(), entity.getTo()));
        };

        return toRequestInWorkflow(request, entity.getStatus());
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

    private static RequestInWorkflow toRequestInWorkflow(WorkingTimeRequest request, WorkingTimeRequestStatus status) {
        return switch (status) {
            case CANCELLED -> new CancelledWorkingTimeRequest(request);
            case SENT_FOR_ACCEPTATION -> new SentForAcceptationWorkingTimeRequest(request, null); //todo
            case ACCEPTED -> new AcceptedWorkingTimeRequest(request);
            case SUBMITTED -> new SubmittedWorkingTimeRequest(request);
            case REJECTED -> new RejectedWorkingTimeRequest(request);
        };
    }
}
