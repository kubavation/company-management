package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.exception.InvalidWorkDayEventException;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventAlreadyAssignedInPeriodException;
import com.durys.jakub.companymanagement.domain.workingtime.schedule.WorkDayType;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class WorkDay {
    private final WorkDayId id;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private List<WorkDayEvent> events;

    public WorkDay(@NonNull WorkDayId id, @NonNull EmployeeId employeeId, @NonNull LocalDate day, @NonNull WorkDayType type) {
        this(id, employeeId, day, Collections.emptyList());
    }

    public WorkDay(@NonNull WorkDayId id, @NonNull EmployeeId employeeId,
                   @NonNull LocalDate day, @NonNull List<WorkDayEvent> events) {
        this.id = id;
        this.employeeId = employeeId;
        this.day = day;
        this.events = events;
    }

    public void assignOvertime(@NonNull LocalTime from, @NonNull LocalTime to) {

        validateEventPeriod(from, to);

        events.add(new WorkDayEvent(from, to, WorkDayEventType.OVERTIME));
    }

    public void assignPrivateExit(@NonNull LocalTime from, @NonNull LocalTime to) {

        validateEventPeriod(from, to);

        if (dayOff()) {
            throw new InvalidWorkDayEventException("Private exit cannot be assigned in day off");
        }

        events.add(new WorkDayEvent(from, to, WorkDayEventType.PRIVATE_EXIT));
    }


    private boolean dayOff() {
        return WorkDayType.DAY_OFF.equals(type);
    }

    private boolean workingDay() {
        return !dayOff();
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
