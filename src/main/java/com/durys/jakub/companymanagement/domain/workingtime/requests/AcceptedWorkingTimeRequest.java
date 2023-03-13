package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public class AcceptedWorkingTimeRequest implements RequestInWorkflow {

    private final WorkingTimeRequest request;

    public AcceptedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    @Override
    public WorkingTimeRequest request() {
        return request;
    }
}
