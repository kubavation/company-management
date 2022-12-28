package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class GrantLeaveRequestPrivilegesCommand implements Command {
    private final String leaveType;
    private final UUID employeeId;
    private final LocalDate from;
    private final LocalDate to;
    private final BigDecimal daysEntitled;
    private final BigDecimal hoursEntitled;
}
