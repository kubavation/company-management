package com.durys.jakub.companymanagement.application.workingtime.listeners;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import com.durys.jakub.companymanagement.domain.workingtime.*;
import com.durys.jakub.companymanagement.domain.workingtime.event.WorkingTimeRequestAcceptedEvent;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class WorkingTimeRequestAcceptedListener {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    @DomainEventListener
    public void onWorkingTimeRequestAcceptation(WorkingTimeRequestAcceptedEvent event) {

        Schedule schedule = scheduleRepository.load(event.scheduleId());

        if (!(schedule instanceof WorkDay workDay)) {
          throw new UnsupportedOperationException();
        }

        var handler = handlerFrom(event);
        handler.accept(workDay);
    }

    private static Consumer<Schedule> handlerFrom(WorkingTimeRequestAcceptedEvent event) {

        WorkDayEventPeriod period = new WorkDayEventPeriod(event.period().from(), event.period().to());

        return switch (event.type()) {
            case PRIVATE_EXIT -> (schedule -> ((WorkDay)schedule).assignPrivateExit(period));
            case WORK_OFF -> (schedule -> schedule.assignWorkOff(period));
        };
    }
}
