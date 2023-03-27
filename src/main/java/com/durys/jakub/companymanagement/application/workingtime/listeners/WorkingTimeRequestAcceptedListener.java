package com.durys.jakub.companymanagement.application.workingtime.listeners;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import com.durys.jakub.companymanagement.domain.workingtime.Schedule;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleRepository;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleService;
import com.durys.jakub.companymanagement.domain.workingtime.event.WorkingTimeRequestAcceptedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class WorkingTimeRequestAcceptedListener {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleService scheduleService;

    @Transactional
    @DomainEventListener
    public void onWorkingTimeRequestAcceptation(WorkingTimeRequestAcceptedEvent event) {

        Schedule schedule = scheduleRepository.load(event.scheduleId());

        scheduleService.handlerFrom(event)
                .accept(schedule);

        scheduleRepository.save(schedule);
    }

}
