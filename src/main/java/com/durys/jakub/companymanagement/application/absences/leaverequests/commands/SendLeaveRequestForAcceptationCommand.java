package com.durys.jakub.companymanagement.application.absences.leaverequests.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SendLeaveRequestForAcceptationCommand implements Command {
    private final UUID leaveRequestId;
    private final UUID acceptantId;
}
