package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.out_adapters.LeaveRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestAggregateAssembler implements AggregateAssembler<LeaveRequestEntity, LeaveRequest> {

    @Override
    public LeaveRequestEntity toEntity(LeaveRequest aggregate) {
        return LeaveRequestEntity.builder()
                .id(aggregate.getRequestId().value())
                .requestStatus(aggregate.getStatus())
                .employeeId(aggregate.getApplicant().getApplicantId().getValue())
                .acceptingId(aggregate.getAcceptant().getAccptantId().getValue())
                .dateFrom(aggregate.getPeriod().getFrom())
                .dateTo(aggregate.getPeriod().getTo())
                .type(aggregate.getRequestType())
                .build();
    }

    @Override
    public LeaveRequest toAggregate(LeaveRequestEntity entity) {
//        return new LeaveRequestAggregate.Builder(new LeaveRequestId(entity.getId()))
//                .applicant(new Applicant(new ApplicantId(entity.getEmployeeId()))) //todo
//                .acceptant(new Acceptant(new AcceptantId(entity.getAcceptingId()))) //todo
//                .period(new LeaveRequestDailyPeriod(entity.getDateFrom(), entity.getDateTo()))
//                .status(entity.getRequestStatus())
//                .requestType(entity.getType())
//                .build();
        return null;
    }
}
