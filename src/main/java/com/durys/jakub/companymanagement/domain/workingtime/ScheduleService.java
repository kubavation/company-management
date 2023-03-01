package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

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
            case THREE_MONTHS -> new Period(LocalDate.now(), LocalDate.now());
            default -> throw new IllegalStateException("Unexpected value: " + billingPeriod);
        };
    }

}
