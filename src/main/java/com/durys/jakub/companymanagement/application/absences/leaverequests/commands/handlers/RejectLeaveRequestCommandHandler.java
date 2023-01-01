package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.RejectLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class RejectLeaveRequestCommandHandler implements CommandHandler<RejectLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void handle(RejectLeaveRequestCommand command) {

        Acceptant acceptant = employeeRepository.load(new AcceptantId(command.getAcceptantId()));

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.getLeaveRequestId()));

        acceptant.reject(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
