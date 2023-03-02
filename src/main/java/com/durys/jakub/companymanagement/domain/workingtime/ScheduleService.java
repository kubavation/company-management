package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.billingperiod.BillingPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.billingperiod.BillingPeriodPolicy;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@DomainService
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final BillingPeriodPolicy billingPeriodPolicy;


    public boolean isWorkOffApplicable(@NonNull EmployeeId employeeId, @NonNull LocalDate atDay, @NonNull Duration durationOfWorkOff) {
        Duration durationOfPrivateExits = durationOfWorkDayEventInBillingPeriod(employeeId, WorkDayEventType.PRIVATE_EXIT, atDay);
        return durationOfPrivateExits.compareTo(durationOfWorkOff) >= 0;
    }

    public boolean isOvertimeTakenApplicable(@NonNull EmployeeId employeeId, @NonNull LocalDate atDay, @NonNull Duration durationOfOvertimeTaken) {
        Duration durationOfOvertimes = durationOfWorkDayEventInBillingPeriod(employeeId, WorkDayEventType.OVERTIME, atDay);
        return durationOfOvertimes.compareTo(durationOfOvertimeTaken) >= 0;
    }

    public Duration durationOfWorkDayEventInBillingPeriod(@NonNull EmployeeId employeeId, @NonNull WorkDayEventType eventType, @NonNull LocalDate atDay) {

        BillingPeriod billingPeriod = billingPeriodPolicy.billingPeriod();

        Period period = periodFromBillingPeriod(atDay, billingPeriod);

        return scheduleRepository.durationOfWorkDayEventInPeriod(eventType, employeeId, period.from, period.to);
    }

    private record Period(LocalDate from, LocalDate to) {}

    private Period periodFromBillingPeriod(LocalDate atDay, BillingPeriod billingPeriod) {
        return switch (billingPeriod) {
            case THREE_MONTHS -> periodFromThreeMonthsBillingPeriod(atDay);
            case ONE_MONTH -> new Period(atDay.with(TemporalAdjusters.firstDayOfMonth()), atDay.with(TemporalAdjusters.lastDayOfMonth()));
            case FOUR_MONTHS -> periodFromFourMonthsBillingPeriod(atDay);
        };
    }

    private Period periodFromThreeMonthsBillingPeriod(LocalDate atDay) {
        LocalDate from = atDay.with(atDay.getMonth().firstMonthOfQuarter()).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate to = from.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        return new Period(from, to);
    }

    private Period periodFromFourMonthsBillingPeriod(LocalDate atDay) {
        if (atDay.getMonth().getValue() < Month.MAY.getValue()) {
            return new Period(atDay.withMonth(Month.JANUARY.getValue()).with(TemporalAdjusters.firstDayOfMonth()),
                    atDay.withMonth(Month.APRIL.getValue()).with(TemporalAdjusters.lastDayOfMonth()));
        } else if (atDay.getMonth().getValue() < Month.JULY.getValue()) {
            return new Period(atDay.withMonth(Month.MAY.getValue()).with(TemporalAdjusters.firstDayOfMonth()),
                    atDay.withMonth(Month.JUNE.getValue()).with(TemporalAdjusters.lastDayOfMonth()));
        } else {
            return new Period(atDay.withMonth(Month.SEPTEMBER.getValue()).with(TemporalAdjusters.firstDayOfMonth()),
                    atDay.withMonth(Month.DECEMBER.getValue()).with(TemporalAdjusters.lastDayOfMonth()));
        }

    }

}
