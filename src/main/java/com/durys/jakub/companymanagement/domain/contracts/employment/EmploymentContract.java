package com.durys.jakub.companymanagement.domain.contracts.employment;

import com.durys.jakub.companymanagement.domain.employees.model.EmploymentPeriodService;

import java.time.Period;

public interface EmploymentContract {
    NoticePeriod noticePeriod(EmploymentPeriodService.EmploymentPeriod employmentPeriod);
}