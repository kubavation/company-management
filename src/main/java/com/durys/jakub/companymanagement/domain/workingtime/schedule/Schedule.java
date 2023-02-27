package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract sealed class Schedule permits WorkDay, DayOff {

    private final ScheduleId scheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final SchedulePeriod period;
    private final WorkDayType dayType;

    protected Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull WorkDayType dayType,
                    @NonNull LocalDate day, @NonNull LocalTime from, @NonNull LocalTime to) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.period = new SchedulePeriod(from, to);
    }

    protected Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull WorkDayType dayType, @NonNull LocalDate day) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.period = null;
    }

    public boolean dayOff() {
        return WorkDayType.DAY_OFF.equals(dayType);
    }

    public boolean workingDay() {
        return !dayOff();
    }

    public ScheduleId id() {
        return scheduleId;
    }


}
