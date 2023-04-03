package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.domain.workingtime.requests.RequestInWorkflow;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;

import java.util.HashMap;

public class HashMapWorkingTimeRequestRepository implements WorkingTimeRequestRepository {

    private static final HashMap<WorkingTimeRequestId, RequestInWorkflow> DB = new HashMap<>();

    @Override
    public RequestInWorkflow load(WorkingTimeRequestId id) {
        return null;
    }

    @Override
    public void save(RequestInWorkflow request) {

    }
}
