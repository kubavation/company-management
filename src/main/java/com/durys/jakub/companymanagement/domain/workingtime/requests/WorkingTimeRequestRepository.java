package com.durys.jakub.companymanagement.domain.workingtime.requests;


public interface WorkingTimeRequestRepository {
    WorkingTimeRequest load(WorkingTimeRequestId id);
    void save(WorkingTimeRequest request);
}
