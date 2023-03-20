package com.durys.jakub.companymanagement.application.absences.leaverequests.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.util.UUID;


public record CancelLeaveRequestCommand(UUID applicantId, UUID leaveRequestId) implements Command {
}