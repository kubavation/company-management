package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public record GrantLeaveRequestPrivilegesCommand(String leaveType, UUID employeeId, LocalDate from, LocalDate to,
                                                 BigDecimal daysEntitled, BigDecimal hoursEntitled) implements Command {
}
