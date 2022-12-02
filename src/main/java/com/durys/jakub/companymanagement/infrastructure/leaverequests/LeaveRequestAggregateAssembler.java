package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.Acceptant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestAggregateAssembler implements AggregateAssembler<LeaveRequestEntity, LeaveRequestAggregate> {

    @Override
    public LeaveRequestEntity toEntity(LeaveRequestAggregate aggregate) {
        return LeaveRequestEntity.builder()
                .id(aggregate.getRequestId().value())
                .requestStatus(aggregate.getStatus())
                .employeeId(aggregate.getApplicant().getApplicantId().getId())
                .acceptingId(aggregate.getAcceptant().getAccptantId().getId())
                .dateFrom(aggregate.getPeriod().getDateFrom())
                .dateTo(aggregate.getPeriod().getDateTo())
                .type(aggregate.getRequestType())
                .build();
    }

    @Override
    public LeaveRequestAggregate toAggregate(LeaveRequestEntity entity) {
        return new LeaveRequestAggregate.Builder(new LeaveRequestId(entity.getId()))
                .applicant(new Applicant(new ApplicantId(entity.getEmployeeId()))) //todo
                .acceptant(new Acceptant(new AcceptantId(entity.getAcceptingId()))) //todo
                .period(new LeaveRequestPeriod(entity.getDateFrom(), entity.getDateTo()))
                .status(entity.getRequestStatus())
                .requestType(entity.getType())
                .build();

    }
}
