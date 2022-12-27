package com.durys.jakub.companymanagement.application.leaverequests.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class SubmitLeaveRequestCommand implements Command {
    private final Long applicantId;
    private final LeaveRequestType type;
    private final LocalDateTime from;
    private final LocalDateTime to;
}