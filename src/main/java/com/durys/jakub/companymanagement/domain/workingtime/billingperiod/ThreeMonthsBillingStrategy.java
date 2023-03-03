package com.durys.jakub.companymanagement.domain.workingtime.billingperiod;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ThreeMonthsBillingStrategy implements BillingPeriodStrategy {

    @Override
    public Period periodFrom(LocalDate day, BillingPeriod billingPeriod) {
        LocalDate from = day.with(day.getMonth().firstMonthOfQuarter()).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate to = from.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        return new Period(from, to);
    }
}
