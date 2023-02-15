package com.durys.jakub.companymanagement.domain.workingtime;

public interface WorkDayRepository {
    WorkDay load(WorkDayId id);
    void save(WorkDay workDay);
}
