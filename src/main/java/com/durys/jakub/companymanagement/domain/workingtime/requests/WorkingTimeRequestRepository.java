package com.durys.jakub.companymanagement.domain.workingtime.requests;


public interface WorkingTimeRequestRepository {
    RequestInWorkflow load(WorkingTimeRequestId id);
    void save(RequestInWorkflow request);
}
