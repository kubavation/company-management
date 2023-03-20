package com.durys.jakub.companymanagement.application.absences.leaverequests.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

import java.time.LocalDateTime;
import java.util.UUID;

public record SubmitLeaveRequestCommand(UUID applicantId, LeaveRequestType type, LocalDateTime from,
                                        LocalDateTime to) implements Command {
}