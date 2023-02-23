package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {

    private final WorkingScheduleId workingScheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final LocalTime from;
    private final LocalTime to;
    private final WorkDayType dayType;

    public Schedule(WorkingScheduleId workingScheduleId, EmployeeId employeeId, WorkDayType dayType, LocalDate day, LocalTime from, LocalTime to) {
        this.workingScheduleId = workingScheduleId;
        this.employeeId = employeeId;
        this.dayType = dayType;
        this.day = day;
        this.from = from;
        this.to = to;
    }

    public static Schedule dayOff(WorkingScheduleId workingScheduleId, EmployeeId employeeId, LocalDate day) {
        return new Schedule(workingScheduleId, employeeId, WorkDayType.DAY_OFF, day, null, null);
    }

    public static Schedule workingDay(WorkingScheduleId workingScheduleId, EmployeeId employeeId, LocalDate day, LocalTime from, LocalTime to) {
        return new Schedule(workingScheduleId, employeeId, WorkDayType.SCHEDULE, day, from, to);
    }


    public boolean dayOff() {
        return WorkDayType.DAY_OFF.equals(dayType);
    }

    public boolean workingDay() {
        return !dayOff();
    }

}
