package com.durys.jakub.companymanagement.domain.contracts.employment;

import java.time.Period;

public interface EmploymentContract {
    NoticePeriod noticePeriod(Period employmentPeriod);
}