package com.durys.jakub.companymanagement.domain.workingtime.requests;
import lombok.NonNull;

public class RejectedWorkingTimeRequest implements RequestInWorkflow {

    private final WorkingTimeRequest request;

    public RejectedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    @Override
    public WorkingTimeRequest request() {
        return request;
    }
}
