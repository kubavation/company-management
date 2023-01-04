package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.commons.events.publisher.DomainEventPublisher;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.events.LeaveRequestAcceptedEvent;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
class LeaveRequestAcceptationService {

    private final DomainEventPublisher domainEventPublisher;

    void affectPermissions(LeaveRequestAcceptedEvent event) {
        domainEventPublisher.publish(event);
    }

}
