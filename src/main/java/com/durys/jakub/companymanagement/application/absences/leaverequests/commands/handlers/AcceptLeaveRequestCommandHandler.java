package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.AcceptLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class AcceptLeaveRequestCommandHandler implements CommandHandler<AcceptLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveEntitlementsRepository leaveEntitlementsRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void handle(AcceptLeaveRequestCommand command) {

        Acceptant acceptant = employeeRepository.load(new AcceptantId(command.getAcceptantId()));

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.getLeaveRequestId()));

        //todo check leavePrivileges again / explore domain

        acceptant.accept(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
