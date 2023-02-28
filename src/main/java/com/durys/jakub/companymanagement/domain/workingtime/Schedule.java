package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventAlreadyAssignedInPeriodException;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public abstract sealed class Schedule
        permits DayOff, WorkDay {

    private final ScheduleId scheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final SchedulePeriod period;
    private final List<WorkDayEvent> events;

    protected Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId,
                       @NonNull LocalDate day, @NonNull LocalTime from, @NonNull LocalTime to,
                       @NonNull List<WorkDayEvent> events) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.day = day;
        this.period = new SchedulePeriod(from, to);
        this.events = events;
    }

    protected Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull LocalDate day,
                       @NonNull List<WorkDayEvent> events) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.day = day;
        this.period = null;
        this.events = events;
    }


    public void assignWorkOff(@NonNull WorkDayEventPeriod period) {
        appendEvent(period, WorkDayEventType.WORK_OFF);
    }

    public void assignOvertime(@NonNull WorkDayEventPeriod period) {
        appendEvent(period, WorkDayEventType.OVERTIME);
    }

    public void assignOvertimeTaken(@NonNull WorkDayEventPeriod period) {
        appendEvent(period, WorkDayEventType.OVERTIME_TAKEN);
    }


    protected void appendEvent(@NonNull WorkDayEventPeriod period, @NonNull WorkDayEventType type) {
        validate(period);
        events.add(new WorkDayEvent(period, type));
    }

    protected void validate(WorkDayEventPeriod eventPeriod) {

        if (isPeriodOverlappingAnotherEvent(eventPeriod)) {
            throw new WorkDayEventAlreadyAssignedInPeriodException();
        }
    }

    private boolean isPeriodOverlappingAnotherEvent(WorkDayEventPeriod eventPeriod) {
        return events.stream()
                .filter(event -> !event.getType().equals(WorkDayEventType.SCHEDULE_REALIZATION))
                .anyMatch(event -> eventPeriod.from().isBefore(event.to()) && event.from().isBefore(eventPeriod.to()));
    }

    public ScheduleId id() {
        return scheduleId;
    }

    protected SchedulePeriod period() {
        return period;
    }

}
