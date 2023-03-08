package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.DeleteLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class DeleteLeaveRequestCommandHandler implements CommandHandler<DeleteLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void handle(DeleteLeaveRequestCommand command) {

        Applicant applicant = employeeRepository.load(new AcceptantId(command.applicantId()));

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.leaveRequestId()));

        applicant.delete(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
