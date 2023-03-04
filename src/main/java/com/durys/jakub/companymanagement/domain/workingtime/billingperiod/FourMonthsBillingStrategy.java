package com.durys.jakub.companymanagement.domain.workingtime.billingperiod;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public final class FourMonthsBillingStrategy implements BillingPeriodStrategy {

    @Override
    public Period periodFrom(LocalDate day) {
        if (day.getMonth().getValue() < Month.MAY.getValue()) {
            return new Period(day.withMonth(Month.JANUARY.getValue()).with(TemporalAdjusters.firstDayOfMonth()),
                    day.withMonth(Month.APRIL.getValue()).with(TemporalAdjusters.lastDayOfMonth()));
        } else if (day.getMonth().getValue() < Month.JULY.getValue()) {
            return new Period(day.withMonth(Month.MAY.getValue()).with(TemporalAdjusters.firstDayOfMonth()),
                    day.withMonth(Month.JUNE.getValue()).with(TemporalAdjusters.lastDayOfMonth()));
        } else {
            return new Period(day.withMonth(Month.SEPTEMBER.getValue()).with(TemporalAdjusters.firstDayOfMonth()),
                    day.withMonth(Month.DECEMBER.getValue()).with(TemporalAdjusters.lastDayOfMonth()));
        }
    }
}
