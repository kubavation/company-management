package com.durys.jakub.companymanagement.infrastructure.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.Schedule;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleId;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleRepository;
import com.durys.jakub.companymanagement.domain.workingtime.WorkDayEventType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Duration;
import java.time.LocalDate;

@RequiredArgsConstructor
public class JdbcScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Schedule load(ScheduleId id) {
        return null;
    }

    @Override
    public void save(Schedule schedule) {

    }

    @Override
    public Duration durationOfWorkDayEventInPeriod(WorkDayEventType type, EmployeeId employeeId, LocalDate from, LocalDate to) {
        return null;
    }
}
