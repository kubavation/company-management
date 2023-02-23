package com.durys.jakub.companymanagement.domain.workingtime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalTime;

@Getter(AccessLevel.PACKAGE)
class WorkDayEvent {
    private final WorkDayEventPeriod period;
    private final WorkDayEventType type;

    public WorkDayEvent(@NonNull WorkDayEventPeriod period, @NonNull WorkDayEventType type) {
        this.period = period;
        this.type = type;
    }

    public LocalTime from() {
        return period.from();
    }

    public LocalTime to() {
        return period.to();
    }

}
