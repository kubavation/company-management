package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.workingtime.requests.RequestInWorkflow;
import com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output.WorkingTimeRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkingTimeRequestAggregateAssembler implements AggregateAssembler<WorkingTimeRequestEntity, RequestInWorkflow> {


    @Override
    public WorkingTimeRequestEntity toEntity(RequestInWorkflow aggregate) {
        return null;
    }

    @Override
    public RequestInWorkflow toAggregate(WorkingTimeRequestEntity entity) {
        return null;
    }
}
