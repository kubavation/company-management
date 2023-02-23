package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.exception.InvalidWorkDayEventException;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventAlreadyAssignedInPeriodException;
import com.durys.jakub.companymanagement.domain.workingtime.schedule.Schedule;
import lombok.NonNull;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class WorkDay {
    private final WorkDayId id;
    private final Schedule schedule;
    private final List<WorkDayEvent> events;

    public WorkDay(@NonNull Schedule schedule) {
        this(schedule, Collections.emptyList());
    }

    public WorkDay(@NonNull Schedule schedule, @NonNull List<WorkDayEvent> events) {
        this.id = new WorkDayId(schedule.id().value());
        this.schedule = schedule;
        this.events = events;
    }


    public void assignPrivateExit(@NonNull LocalTime from, @NonNull LocalTime to) {

        validateEventPeriod(from, to);

        if (schedule.dayOff()) {
            throw new InvalidWorkDayEventException("Private exit cannot be assigned in day off");
        }

        events.add(new WorkDayEvent(new WorkDayEventPeriod(from, to), WorkDayEventType.PRIVATE_EXIT));
    }


    public void assignOvertime(@NonNull LocalTime from, @NonNull LocalTime to) {

        validateEventPeriod(from, to);

        events.add(new WorkDayEvent(new WorkDayEventPeriod(from, to), WorkDayEventType.OVERTIME));
    }

    private void validateEventPeriod(LocalTime from, LocalTime to) {

       if (isPeriodOverlappingAnotherEvent(from, to)) {
           throw new WorkDayEventAlreadyAssignedInPeriodException();
       }

    }

    private boolean isPeriodOverlappingAnotherEvent(LocalTime from, LocalTime to) {
       return events.stream()
                .filter(event -> !event.getType().equals(WorkDayEventType.SCHEDULE_REALIZATION))
                .anyMatch(event -> from.isBefore(event.to()) && event.from().isBefore(to));
    }

    public WorkDayId getId() {
        return id;
    }
}
