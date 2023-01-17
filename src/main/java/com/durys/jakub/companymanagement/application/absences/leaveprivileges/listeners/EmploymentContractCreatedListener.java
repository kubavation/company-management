package com.durys.jakub.companymanagement.application.absences.leaveprivileges.listeners;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.domain.contracts.event.EmploymentContractAssignedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class EmploymentContractCreatedListener {

    private final LeaveEntitlementsRepository leaveEntitlementsRepository;

    @Transactional
    @DomainEventListener
    public void onEmploymentContractAssigned(EmploymentContractAssignedEvent event) {

        LeaveEntitlements leaveEntitlements = leaveEntitlementsRepository.load(event.employeeId());
        //todo

        leaveEntitlementsRepository.save(leaveEntitlements);
    }
}
