package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.exception.InvalidWorkDayEventException;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventAlreadyAssignedInPeriodException;
import com.durys.jakub.companymanagement.domain.workingtime.schedule.WorkingSchedule;
import lombok.NonNull;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class WorkDay {
    private final WorkDayId id;
    private final WorkingSchedule schedule;
    private List<WorkDayEvent> events;

    public WorkDay(@NonNull WorkDayId id, @NonNull WorkingSchedule schedule) {
        this(id, schedule, Collections.emptyList());
    }

    public WorkDay(@NonNull WorkDayId id, @NonNull WorkingSchedule schedule, @NonNull List<WorkDayEvent> events) {
        this.id = id;
        this.schedule = schedule;
        this.events = events;
    }


    public void assignPrivateExit(@NonNull LocalTime from, @NonNull LocalTime to) {

        validateEventPeriod(from, to);

        if (schedule.dayOff()) {
            throw new InvalidWorkDayEventException("Private exit cannot be assigned in day off");
        }

        events.add(new WorkDayEvent(from, to, WorkDayEventType.PRIVATE_EXIT));
    }


    public void assignOvertime(@NonNull LocalTime from, @NonNull LocalTime to) {

        validateEventPeriod(from, to);

        events.add(new WorkDayEvent(from, to, WorkDayEventType.OVERTIME));
    }

    private void validateEventPeriod(LocalTime from, LocalTime to) {

       if (isPeriodOverlappingAnotherEvent(from, to)) {
           throw new WorkDayEventAlreadyAssignedInPeriodException();
       }

    }

    private boolean isPeriodOverlappingAnotherEvent(LocalTime from, LocalTime to) {
       return events.stream()
                .filter(event -> !event.getType().equals(WorkDayEventType.SCHEDULE_REALIZATION))
                .anyMatch(event -> from.isBefore(event.getTo()) && event.getFrom().isBefore(to));
    }

}
