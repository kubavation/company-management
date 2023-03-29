package com.durys.jakub.companymanagement.domain.contracts.employment;

import com.durys.jakub.companymanagement.domain.employees.EmploymentPeriodService;


public interface EmploymentContract {
    NoticePeriod noticePeriod(EmploymentPeriodService.EmploymentPeriod employmentPeriod);
}