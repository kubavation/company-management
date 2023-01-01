package com.durys.jakub.companymanagement.application.absences.leaverequests.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class DeleteLeaveRequestCommand implements Command {
    private final UUID applicantId;
    private final UUID leaveRequestId;
}