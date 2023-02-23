package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {

    private final ScheduleId scheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final LocalTime from;
    private final LocalTime to;
    private final WorkDayType dayType;

    public Schedule(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull WorkDayType dayType,
                    @NonNull LocalDate day, LocalTime from, LocalTime to) {
        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.from = from;
        this.to = to;
    }

    public static Schedule dayOff(ScheduleId scheduleId, EmployeeId employeeId, LocalDate day) {
        return new Schedule(scheduleId, employeeId, WorkDayType.DAY_OFF, day, null, null);
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
