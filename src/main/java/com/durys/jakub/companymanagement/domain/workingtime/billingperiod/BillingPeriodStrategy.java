package com.durys.jakub.companymanagement.domain.workingtime.billingperiod;

import java.time.LocalDate;

public interface BillingPeriodStrategy {
    Period periodFrom(LocalDate day, BillingPeriod billingPeriod);
}
