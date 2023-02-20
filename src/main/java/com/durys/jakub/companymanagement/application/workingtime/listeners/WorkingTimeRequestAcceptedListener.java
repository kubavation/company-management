package com.durys.jakub.companymanagement.application.workingtime.listeners;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import com.durys.jakub.companymanagement.domain.workingtime.WorkDayRepository;
import com.durys.jakub.companymanagement.domain.workingtime.event.WorkingTimeRequestAcceptedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class WorkingTimeRequestAcceptedListener {

    private final WorkDayRepository workDayRepository;

    @Transactional
    @DomainEventListener
    public void onWorkingTimeRequestAcceptation(WorkingTimeRequestAcceptedEvent event) {
        //todo
    }
}