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
    private final ScheduleService scheduleService;

    @Transactional
    @DomainEventListener
    public void onWorkingTimeRequestAcceptation(WorkingTimeRequestAcceptedEvent event) {

        Schedule schedule = scheduleRepository.load(event.scheduleId());

        var handler = scheduleService.handlerFrom(event);
        handler.accept(schedule);

        scheduleRepository.save(schedule);
    }

}
