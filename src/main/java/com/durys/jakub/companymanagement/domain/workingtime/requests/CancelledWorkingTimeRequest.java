package com.durys.jakub.companymanagement.domain.workingtime.requests;
import lombok.NonNull;

public record CancelledWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow {

    public CancelledWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }
}
