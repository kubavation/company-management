package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.billingperiod.*;
import com.durys.jakub.companymanagement.domain.workingtime.event.WorkingTimeRequestAcceptedEvent;
import com.durys.jakub.companymanagement.domain.workingtime.exception.DurationOfWorkOffEventExceedPrivateExitDurationException;
import com.durys.jakub.companymanagement.domain.workingtime.exception.WorkDayEventNotApplicableInDayOffException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.function.Consumer;

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

        return scheduleRepository.durationOfWorkDayEventInPeriod(eventType, employeeId, period.from(), period.to());
    }

    private Period periodFromBillingPeriod(LocalDate atDay, BillingPeriod billingPeriod) {
        return switch (billingPeriod) {
            case THREE_MONTHS -> new ThreeMonthsBillingStrategy().periodFrom(atDay);
            case ONE_MONTH -> new OneMonthsBillingStrategy().periodFrom(atDay);
            case FOUR_MONTHS -> new FourMonthsBillingStrategy().periodFrom(atDay);
        };
    }


    public Consumer<Schedule> handler(WorkingTimeRequestAcceptedEvent event) {
        return switch (event.type()) {
            case PRIVATE_EXIT -> privateExitEventHandler(event);
            case WORK_OFF -> workOffEventHandler(event);
            case OVERTIME -> overtimeEventHandler(event);
            case OVERTIME_TAKEN -> overtimeTakenEventHandler(event);
        };
    }

    private Consumer<Schedule> overtimeTakenEventHandler(WorkingTimeRequestAcceptedEvent event) {
        return schedule -> {

            if (isOvertimeTakenApplicable(event.employeeId(), event.atDay(), Duration.ofMinutes(event.period().minutes()))) {
                throw new DurationOfWorkOffEventExceedPrivateExitDurationException();
            }

            schedule.assignOvertimeTaken(new WorkDayEventPeriod(event.from(), event.to()));
        };
    }

    private Consumer<Schedule> overtimeEventHandler(WorkingTimeRequestAcceptedEvent event) {
        return schedule -> {



            schedule.assignOvertime(new WorkDayEventPeriod(event.from(), event.to()));
        };
    }


    private Consumer<Schedule> privateExitEventHandler(WorkingTimeRequestAcceptedEvent event) {
        return schedule -> {
            if (!(schedule instanceof WorkDay workDay)) {
                throw new WorkDayEventNotApplicableInDayOffException();
            }
            workDay.assignPrivateExit(new WorkDayEventPeriod(event.from(), event.to()));
        };
    }


    private Consumer<Schedule> workOffEventHandler(WorkingTimeRequestAcceptedEvent event) {
        return schedule -> {
            if (!isWorkOffApplicable(event.employeeId(), event.atDay(), Duration.ofMinutes(event.period().minutes()))) {
                throw new DurationOfWorkOffEventExceedPrivateExitDurationException();
            }
            schedule.assignWorkOff(new WorkDayEventPeriod(event.from(), event.to()));
        };
    }

}
