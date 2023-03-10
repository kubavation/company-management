package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public class SentToAcceptationWorkingTimeRequest {

    private final WorkingTimeRequest request;

    public SentToAcceptationWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }
}
