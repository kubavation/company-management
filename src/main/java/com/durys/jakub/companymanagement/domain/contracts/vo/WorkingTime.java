package com.durys.jakub.companymanagement.domain.contracts.vo;


public class WorkingTime {

    private final DailyHourNumber dailyHourNumber;
    private final BillingPeriod billingPeriod;

    public WorkingTime(DailyHourNumber dailyHourNumber, BillingPeriod billingPeriod) {
        this.dailyHourNumber = dailyHourNumber;
        this.billingPeriod = billingPeriod;
    }
}
