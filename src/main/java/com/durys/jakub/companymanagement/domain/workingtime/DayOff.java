package com.durys.jakub.companymanagement.domain.workingtime;

import lombok.NonNull;

import java.util.List;

public final class DayOff extends Schedule {

    public DayOff(@NonNull ScheduleId scheduleId, @NonNull List<WorkDayEvent> events) {
        super(scheduleId, events);
    }
}
