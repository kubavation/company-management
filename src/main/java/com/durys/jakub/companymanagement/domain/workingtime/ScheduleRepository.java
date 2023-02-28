package com.durys.jakub.companymanagement.domain.workingtime;

public interface ScheduleRepository {

    Schedule load(ScheduleId id);
    void save(Schedule schedule);
}
