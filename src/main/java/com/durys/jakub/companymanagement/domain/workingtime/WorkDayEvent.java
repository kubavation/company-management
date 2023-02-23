package com.durys.jakub.companymanagement.domain.workingtime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

@Getter(AccessLevel.PACKAGE)
class WorkDayEvent {
    private final WorkDayEventPeriod period;
    private final WorkDayEventType type;

    public WorkDayEvent(@NonNull WorkDayEventPeriod period, @NonNull WorkDayEventType type) {
        this.period = period;
        this.type = type;
    }
}
