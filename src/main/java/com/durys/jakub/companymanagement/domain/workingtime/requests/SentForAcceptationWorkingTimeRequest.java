package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

public class SentForAcceptationWorkingTimeRequest {

    private final WorkingTimeRequest request;

    public SentForAcceptationWorkingTimeRequest(@NonNull WorkingTimeRequest request) {
        this.request = request;
    }
}
