package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.GrantLeaveRequestPrivilegesCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class GrantLeaveRequestPrivilegesCommandHandler implements CommandHandler<GrantLeaveRequestPrivilegesCommand> {

    private final LeaveEntitlementEmployeeRepository leaveEntitlementEmployeeRepository;

    @Override
    public void handle(GrantLeaveRequestPrivilegesCommand command) {

        LeaveEntitlementEmployee employee = leaveEntitlementEmployeeRepository.load(EmployeeId.from(command.getEmployeeId()));

        employee.grantWith(LeaveType.valueOf(command.getLeaveType()),
                new LeavePrivilegesPeriod(command.getFrom(), command.getTo()),
                new GrantedPrivileges(command.getDaysEntitled(), command.getHoursEntitled()));

        leaveEntitlementEmployeeRepository.save(employee);
    }
}
