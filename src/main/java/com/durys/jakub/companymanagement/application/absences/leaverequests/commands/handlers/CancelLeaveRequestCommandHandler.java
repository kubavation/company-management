package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.CancelLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class CancelLeaveRequestCommandHandler implements CommandHandler<CancelLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void handle(CancelLeaveRequestCommand command) {

        Applicant applicant = employeeRepository.load(new AcceptantId(command.getApplicantId()));

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.getLeaveRequestId()));

        applicant.cancel(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
