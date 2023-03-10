package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public class SubmittedWorkingTimeRequest {

    private final WorkingTimeRequest request;

    public SubmittedWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }

}
