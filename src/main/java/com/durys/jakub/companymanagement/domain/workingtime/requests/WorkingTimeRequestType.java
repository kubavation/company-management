package com.durys.jakub.companymanagement.domain.workingtime.requests;

import io.vavr.collection.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WorkingTimeRequestType {
    PRIVATE_EXIT(PrivateExitRequest.class),
    WORK_OFF(WorkOffRequest.class),
    OVERTIME(OvertimeRequest.class);

    private final Class<? extends WorkingTimeRequest> requestClass;

    public static WorkingTimeRequestType from(Class<? extends WorkingTimeRequest> clazz) {
        return Stream.of(WorkingTimeRequestType.values())
                .filter(type -> type.requestClass.equals(clazz))
                .getOrElseThrow(RuntimeException::new);
    }
}
