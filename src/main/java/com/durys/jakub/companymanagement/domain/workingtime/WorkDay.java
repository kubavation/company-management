package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import com.durys.jakub.companymanagement.domain.workingtime.exception.InvalidWorkDayEventException;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventAlreadyAssignedInPeriodException;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class WorkDay {
    private final WorkDayId id;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final WorkDayType type;
    private List<WorkDayEvent> events;

    public WorkDay(WorkDayId id, EmployeeId employeeId, LocalDate day, WorkDayType type) {
        this.id = id;
        this.employeeId = employeeId;
        this.day = day;
        this.type = type;
        this.events = Collections.emptyList();
    }

    public void assignPrivateExit(@NonNull LocalTime from, @NonNull LocalTime to) {

        RangeValidators
                .comparing(LocalTime.class)
                .validate(from, to);

        if (dayOff()) {
            throw new InvalidWorkDayEventException("Private exit cannot be assigned in day off");
        }

        validateDuration(from, to);

        events.add(new WorkDayEvent(from, to, WorkDayEventType.PRIVATE_EXIT));
    }



    private boolean dayOff() {
        return WorkDayType.DAY_OFF.equals(type);
    }

    private void validateDuration(LocalTime from, LocalTime to) {

        boolean overlaps = events.stream()
                .filter(event -> !event.getType().equals(WorkDayEventType.SCHEDULE_REALIZATION))
                .anyMatch(event -> from.isBefore(event.getTo()) && event.getFrom().isBefore(to));

       if (overlaps) {
           throw new WorkDayEventAlreadyAssignedInPeriodException();
       }
    }

}
