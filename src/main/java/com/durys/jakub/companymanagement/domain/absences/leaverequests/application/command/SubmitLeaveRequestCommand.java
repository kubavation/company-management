package com.durys.jakub.companymanagement.domain.absences.leaverequests.application.command;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public record SubmitLeaveRequestCommand(
        AuthorId authorId, LeaveRequestPeriod period, LeaveRequestType type) implements Command {
}
