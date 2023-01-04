package com.durys.jakub.companymanagement.domain.absences.leaverequests.events;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class LeaveRequestAcceptedEvent implements DomainEvent {

    private final EmployeeId employeeId;
    private final LeaveRequestType leaveRequestType;
    private final LeaveRequestPeriod period;
}
