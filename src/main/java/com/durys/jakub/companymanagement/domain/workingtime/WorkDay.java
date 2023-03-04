package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public final class WorkDay extends Schedule {

    public WorkDay(@NonNull ScheduleId scheduleId, @NonNull LocalTime from, @NonNull LocalTime to, @NonNull List<WorkDayEvent> events) {
        super(scheduleId, from, to, events);
    }

    public void assignPrivateExit(@NonNull WorkDayEventPeriod period) {
        appendEvent(period, WorkDayEventType.PRIVATE_EXIT);
    }

    public void assignBusinessExit(@NonNull WorkDayEventPeriod period) {
        appendEvent(period, WorkDayEventType.BUSINESS_EXIT);
    }

    public Duration duration() {
        return period().duration();
    }
}
