package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.domain.workingtime.requests.RequestInWorkflow;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.output.LeaveRequestEntity;
import com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output.WorkingTimeRequestEntity;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
public class HashMapWorkingTimeRequestRepository implements WorkingTimeRequestRepository {

    private static final HashMap<UUID, WorkingTimeRequestEntity> DB = new HashMap<>();
    private final WorkingTimeRequestAggregateAssembler assembler;

    @Override
    public RequestInWorkflow load(WorkingTimeRequestId id) {
        WorkingTimeRequestEntity entity = DB.get(id.value());

        if (Objects.isNull(entity)) {
            throw new RuntimeException();
        }

        return assembler.toAggregate(entity);
    }

    @Override
    public void save(RequestInWorkflow request) {

    }
}
