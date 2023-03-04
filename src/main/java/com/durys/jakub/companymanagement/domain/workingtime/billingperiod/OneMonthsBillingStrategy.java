package com.durys.jakub.companymanagement.domain.workingtime.billingperiod;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public final class OneMonthsBillingStrategy implements BillingPeriodStrategy {

    @Override
    public Period periodFrom(LocalDate day) {
        return new Period(day.with(TemporalAdjusters.firstDayOfMonth()), day.with(TemporalAdjusters.lastDayOfMonth()));
    }
}
