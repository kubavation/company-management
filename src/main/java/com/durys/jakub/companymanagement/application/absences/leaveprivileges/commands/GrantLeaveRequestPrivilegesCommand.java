package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GrantLeaveRequestPrivilegesCommand(String leaveType, UUID employeeId, LocalDate from, LocalDate to,
                                                 BigDecimal daysEntitled, BigDecimal hoursEntitled) implements Command {
}
