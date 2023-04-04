package com.durys.jakub.companymanagement.application.absences.leaveprivileges.listeners;

import com.durys.jakub.companymanagement.commons.events.DomainEventListener;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.vo.LeaveType;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.events.LeaveRequestAcceptedEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeaveRequestAcceptedListener {

    private final LeaveEntitlementsRepository leaveEntitlementsRepository;

    @Transactional
    @DomainEventListener
    public void onLeaveRequestAcceptation(LeaveRequestAcceptedEvent event) {

        LeaveEntitlements leaveEntitlements = leaveEntitlementsRepository.load(event.getEmployeeId());

        leaveEntitlements = leaveEntitlements
                .recalculate(
                        LeaveType.valueOf(event.getLeaveRequestType().getName()),
                        event.getQuantity(),
                        event.getTo().toLocalDate());

        leaveEntitlementsRepository.save(leaveEntitlements);
    }
}
