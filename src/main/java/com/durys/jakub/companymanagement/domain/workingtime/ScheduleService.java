package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

@DomainService
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final BillingPeriodPolicy billingPeriodPolicy;


    Duration durationOfWorkDayEventInBillingPeriod(@NonNull EmployeeId employeeId, @NonNull WorkDayEventType eventType, @NonNull LocalDate atDay) {

        BillingPeriod billingPeriod = billingPeriodPolicy.billingPeriod();

        Period period = periodFromBillingPeriod(atDay, billingPeriod);

        return scheduleRepository.durationOfWorkDayEventInPeriod(eventType, employeeId, period.from, period.to);
    }

    private record Period(LocalDate from, LocalDate to) {}

    private Period periodFromBillingPeriod(LocalDate atDay, BillingPeriod billingPeriod) {
        return switch (billingPeriod) { //TODO
            case THREE_MONTHS -> periodFromThreeMonthsBillingPeriod(atDay);
            case ONE_MONTH -> new Period(atDay.with(TemporalAdjusters.firstDayOfMonth()), atDay.with(TemporalAdjusters.lastDayOfMonth()));
            default -> throw new IllegalStateException("Unexpected value: " + billingPeriod);
        };
    }

    private Period periodFromThreeMonthsBillingPeriod(LocalDate atDay) {
        LocalDate from = atDay.with(atDay.getMonth().firstMonthOfQuarter()).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate to = from.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        return new Period(from, to);
    }

}
