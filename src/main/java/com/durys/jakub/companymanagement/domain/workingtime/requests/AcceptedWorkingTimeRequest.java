package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public record AcceptedWorkingTimeRequest(WorkingTimeRequest request) implements RequestInWorkflow {

    public AcceptedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }
}
