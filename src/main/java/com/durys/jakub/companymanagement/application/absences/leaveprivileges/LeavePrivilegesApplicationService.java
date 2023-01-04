package com.durys.jakub.companymanagement.application.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.events.LeaveRequestAcceptedEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeavePrivilegesApplicationService {

    private final LeaveEntitlementsRepository leaveEntitlementsRepository;


    @DomainEventListener
    public void on(LeaveRequestAcceptedEvent event) {
        //todo
    }
}
