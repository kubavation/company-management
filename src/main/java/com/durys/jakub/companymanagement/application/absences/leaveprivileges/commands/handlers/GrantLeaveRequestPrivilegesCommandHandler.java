package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.GrantLeaveRequestPrivilegesCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.GrantedPrivileges;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilege;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilegesPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class GrantLeaveRequestPrivilegesCommandHandler implements CommandHandler<GrantLeaveRequestPrivilegesCommand> {

    private final EmployeeRepository employeeRepository;
    private final LeavePrivilegesRepository leavePrivilegesRepository;

    @Override
    public void handle(GrantLeaveRequestPrivilegesCommand command) {

        Employee employee = employeeRepository.load(EmployeeId.from(command.getEmployeeId()));

        LeavePrivilege leavePrivilege = new LeavePrivilege(LeaveRequestType.valueOf(command.getLeaveType()), employee.getId(),
                new LeavePrivilegesPeriod(command.getFrom(), command.getTo()),
                new GrantedPrivileges(command.getDaysEntitled(), command.getHoursEntitled()));

        leavePrivilegesRepository.save(leavePrivilege);
    }
}
