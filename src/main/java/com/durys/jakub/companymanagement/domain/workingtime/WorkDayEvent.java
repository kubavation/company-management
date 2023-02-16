package com.durys.jakub.companymanagement.domain.workingtime;

import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalTime;

@Getter(AccessLevel.PACKAGE)
class WorkDayEvent {
    private final LocalTime from;
    private final LocalTime to;
    private final WorkDayEventType type;

    public WorkDayEvent(LocalTime from, LocalTime to, WorkDayEventType type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }
}
