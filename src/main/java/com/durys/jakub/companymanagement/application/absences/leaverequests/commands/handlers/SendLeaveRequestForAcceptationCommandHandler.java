package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SendLeaveRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.Acceptant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class SendLeaveRequestForAcceptationCommandHandler implements CommandHandler<SendLeaveRequestForAcceptationCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    //todo acceptant repository / explore domain

    @Override
    public void handle(SendLeaveRequestForAcceptationCommand command) {

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.getLeaveRequestId()));

        Acceptant acceptant = employeeRepository.load(new AcceptantId(command.getAcceptantId()));

        acceptant.accept(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
