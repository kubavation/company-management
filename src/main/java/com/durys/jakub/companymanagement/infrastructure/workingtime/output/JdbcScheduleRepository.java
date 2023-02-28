package com.durys.jakub.companymanagement.infrastructure.workingtime.output;

import com.durys.jakub.companymanagement.domain.workingtime.Schedule;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleId;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleRepository;

public class JdbcScheduleRepository implements ScheduleRepository {

    @Override
    public Schedule load(ScheduleId id) {
        return null;
    }

    @Override
    public void save(Schedule schedule) {

    }
}
