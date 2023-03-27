package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WorkingTimeRequestType {
    PRIVATE_EXIT(PrivateExitRequest.class),
    WORK_OFF(WorkOffRequest.class);

    private final Class<? extends WorkingTimeRequest> requestClass;
}
