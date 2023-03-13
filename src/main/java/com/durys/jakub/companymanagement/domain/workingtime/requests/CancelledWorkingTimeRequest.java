package com.durys.jakub.companymanagement.domain.workingtime.requests;
import lombok.NonNull;

public class CancelledWorkingTimeRequest implements RequestInWorkflow {

    private final WorkingTimeRequest request;

    public CancelledWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

    @Override
    public WorkingTimeRequest request() {
        return request;
    }
}
