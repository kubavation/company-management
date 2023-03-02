package com.durys.jakub.companymanagement.infrastructure.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.billingperiod.BillingPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.billingperiod.BillingPeriodPolicy;

public class NoopBillingPeriodPolicy implements BillingPeriodPolicy {

    @Override
    public BillingPeriod billingPeriod() {
        return BillingPeriod.THREE_MONTHS;
    }
}
