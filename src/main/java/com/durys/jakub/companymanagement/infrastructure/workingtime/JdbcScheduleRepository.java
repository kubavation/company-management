package com.durys.jakub.companymanagement.infrastructure.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.Schedule;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleId;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
