package com.durys.jakub.companymanagement.domain.absences.leaverequests.events;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@RequiredArgsConstructor
public class LeaveRequestAcceptedEvent implements DomainEvent {

    private final EmployeeId employeeId;
    private final LeaveRequestType leaveRequestType;
    private final BigDecimal quantity;
    private final LocalDateTime from;
    private final LocalDateTime to;
}
