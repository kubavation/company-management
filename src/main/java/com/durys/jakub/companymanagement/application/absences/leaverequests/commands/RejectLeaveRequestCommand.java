package com.durys.jakub.companymanagement.application.absences.leaverequests.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.util.UUID;


public record RejectLeaveRequestCommand(UUID leaveRequestId, UUID acceptantId) implements Command {
}