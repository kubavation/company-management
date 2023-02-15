package com.durys.jakub.companymanagement.application.workingtime.listeners;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class WorkingTimeRequestAcceptedListener {

    @Transactional
    @DomainEventListener
    public void onWorkingTimeRequesAcceptation(Object event) {
        //todo
    }
}
