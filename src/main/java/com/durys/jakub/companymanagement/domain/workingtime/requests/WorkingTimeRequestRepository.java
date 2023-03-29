package com.durys.jakub.companymanagement.domain.workingtime.requests;


import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;

public interface WorkingTimeRequestRepository {
    RequestInWorkflow load(WorkingTimeRequestId id);
    void save(RequestInWorkflow request);
}
