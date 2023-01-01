package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.GrantLeaveRequestPrivilegesCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.*;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.vo.LeaveType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class GrantLeaveRequestPrivilegesCommandHandler implements CommandHandler<GrantLeaveRequestPrivilegesCommand> {

    private final LeaveEntitlementsRepository leaveEntitlementsRepository;

    @Override
    @Transactional
    public void handle(GrantLeaveRequestPrivilegesCommand command) {

        LeaveEntitlements leaveEntitlements = leaveEntitlementsRepository.load(EmployeeId.from(command.getEmployeeId()));

        leaveEntitlements.add(
                LeaveType.valueOf(command.getLeaveType()), command.getFrom(), command.getTo(),
                command.getDaysEntitled(), command.getHoursEntitled());

        leaveEntitlementsRepository.save(leaveEntitlements);
    }
}
