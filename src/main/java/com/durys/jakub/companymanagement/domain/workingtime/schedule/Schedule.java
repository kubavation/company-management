package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {

    private final ScheduleId scheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final SchedulePeriod period;
    private final WorkDayType dayType;

    private Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull WorkDayType dayType,
                    @NonNull LocalDate day, @NonNull LocalTime from, @NonNull LocalTime to) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.period = new SchedulePeriod(from, to);
    }

    private Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull WorkDayType dayType, @NonNull LocalDate day) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.period = null;
    }

    public static Schedule dayOff(ScheduleId scheduleId, EmployeeId employeeId, LocalDate day) {
        return new Schedule(scheduleId, employeeId, WorkDayType.DAY_OFF, day);
    }

    public static Schedule workingDay(ScheduleId scheduleId, EmployeeId employeeId, LocalDate day, LocalTime from, LocalTime to) {
        return new Schedule(scheduleId, employeeId, WorkDayType.SCHEDULE, day, from, to);
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
