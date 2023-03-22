package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

public class WorkOffRequest implements WorkingTimeRequest {

    private final WorkingTimeRequestId id;
    private final EmployeeId authorId;
    private final RequestInformation information;

    public WorkOffRequest(WorkingTimeRequestId id, EmployeeId authorId, RequestInformation information) {
        this.id = id;
        this.authorId = authorId;
        this.information = information;
    }

    @Override
    public WorkingTimeRequestId id() {
        return id;
    }

    @Override
    public EmployeeId authorId() {
        return authorId;
    }

    @Override
    public RequestInformation information() {
        return information;
    }
}
