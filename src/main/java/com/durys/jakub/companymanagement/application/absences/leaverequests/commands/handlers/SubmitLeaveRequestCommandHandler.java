package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SubmitLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.ApplicantId;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import jakarta.transaction.Transactional;

@CommandHandling
@RequiredArgsConstructor
public class SubmitLeaveRequestCommandHandler implements CommandHandler<SubmitLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveEntitlementsRepository leaveEntitlementsRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void handle(SubmitLeaveRequestCommand command) {

        Applicant applicant = employeeRepository.load(new ApplicantId(command.applicantId()));

        LeaveEntitlements leavePrivileges = leaveEntitlementsRepository.load(new EmployeeId(command.applicantId()));

        LeaveRequest.WorkInProgress workInProgressLeaveRequest = LeaveRequest.WorkInProgress.of(
                command.type(), command.from(), command.to(), leavePrivileges);


        LeaveRequest leaveRequest = applicant.submit(workInProgressLeaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
