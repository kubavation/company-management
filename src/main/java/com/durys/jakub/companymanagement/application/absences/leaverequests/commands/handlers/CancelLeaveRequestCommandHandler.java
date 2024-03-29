package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.CancelLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class CancelLeaveRequestCommandHandler implements CommandHandler<CancelLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void handle(CancelLeaveRequestCommand command) {

        Applicant applicant = employeeRepository.load(new AcceptantId(command.applicantId()));

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.leaveRequestId()));

        applicant.cancel(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
