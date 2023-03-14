package com.durys.jakub.companymanagement.domain.workingtime.requests;
import lombok.NonNull;

public record RejectedWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow {

    public RejectedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }
}
