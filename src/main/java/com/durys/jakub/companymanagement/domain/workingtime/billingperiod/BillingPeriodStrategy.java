package com.durys.jakub.companymanagement.domain.workingtime.billingperiod;

import java.time.LocalDate;

public sealed interface BillingPeriodStrategy
        permits FourMonthsBillingStrategy, OneMonthsBillingStrategy, ThreeMonthsBillingStrategy {
    Period periodFrom(LocalDate day);
}
