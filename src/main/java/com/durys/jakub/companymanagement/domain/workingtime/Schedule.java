package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.exception.InvalidWorkDayEventException;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventAlreadyAssignedInPeriodException;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public abstract sealed class Schedule
        permits DayOff, WorkDay {

    private final ScheduleId scheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final SchedulePeriod period;
    private final WorkDayType dayType;
    private final List<WorkDayEvent> events = Collections.emptyList();

    protected Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull WorkDayType dayType,
                    @NonNull LocalDate day, @NonNull LocalTime from, @NonNull LocalTime to) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.period = new SchedulePeriod(from, to);
    }

    protected Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId,
                       @NonNull WorkDayType dayType, @NonNull LocalDate day) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.period = null;
    }

    public boolean dayOff() {
        return this instanceof WorkDay;
    }

    public boolean workingDay() {
        return !dayOff();
    }

    public ScheduleId id() {
        return scheduleId;
    }

    public void assignPrivateExit(@NonNull WorkDayEventPeriod eventPeriod) {

        validateEventPeriod(eventPeriod);

        if (dayOff()) {
            throw new InvalidWorkDayEventException("Private exit cannot be assigned in day off");
        }

        events.add(new WorkDayEvent(eventPeriod, WorkDayEventType.PRIVATE_EXIT));
    }


    public void assignOvertime(@NonNull WorkDayEventPeriod eventPeriod) {

        validateEventPeriod(eventPeriod);

        events.add(new WorkDayEvent(eventPeriod, WorkDayEventType.OVERTIME));
    }

    private void validateEventPeriod(WorkDayEventPeriod eventPeriod) {

        if (isPeriodOverlappingAnotherEvent(eventPeriod)) {
            throw new WorkDayEventAlreadyAssignedInPeriodException();
        }

    }

    private boolean isPeriodOverlappingAnotherEvent(WorkDayEventPeriod eventPeriod) {
        return events.stream()
                .filter(event -> !event.getType().equals(WorkDayEventType.SCHEDULE_REALIZATION))
                .anyMatch(event -> eventPeriod.from().isBefore(event.to()) && event.from().isBefore(eventPeriod.to()));
    }



}
