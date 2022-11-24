package com.durys.jakub.companymanagement.absences.leaverequests.application.command;


import com.durys.jakub.companymanagement.absences.leaverequests.domain.AuthorId;
import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public record CreateLeaveRequestCommand(
        AuthorId authorId, LeaveRequestPeriod period, LeaveRequestType type) implements Command {
}
