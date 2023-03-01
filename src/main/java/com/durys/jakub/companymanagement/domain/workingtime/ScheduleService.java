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


    Duration durationOfWorkDayEventInBillingPeriod(@NonNull EmployeeId employeeId, @NonNull WorkDayEventType eventType,
                                                   @NonNull LocalDate atDay, @NonNull BillingPeriod billingPeriod) {
        //todo
        return Duration.ofDays(1);
    }
}
