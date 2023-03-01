package com.durys.jakub.companymanagement.infrastructure.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.BillingPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.BillingPeriodPolicy;

public class NoopBillingPeriodPolicy implements BillingPeriodPolicy {

    @Override
    public BillingPeriod billingPeriod() {
        return BillingPeriod.THREE_MONTHS;
    }
}
