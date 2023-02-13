package com.durys.jakub.companymanagement.domain.workingtime;

import java.time.LocalTime;

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
