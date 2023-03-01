package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@DomainService
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


    Duration durationOfWorkDayEventInBillingPeriod(WorkDayEventType eventType, LocalDate atDay, BillingPeriod billingPeriod) {
        //todo
        return Duration.ofDays(1);
    }
}
