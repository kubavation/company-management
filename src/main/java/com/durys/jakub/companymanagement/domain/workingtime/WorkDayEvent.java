package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalTime;

@Getter(AccessLevel.PACKAGE)
class WorkDayEvent {
    private final LocalTime from;
    private final LocalTime to;
    private final WorkDayEventType type;

    public WorkDayEvent(LocalTime from, LocalTime to, WorkDayEventType type) {

        RangeValidators
                .comparing(LocalTime.class)
                .validate(from, to);

        this.from = from;
        this.to = to;
        this.type = type;
    }
}
