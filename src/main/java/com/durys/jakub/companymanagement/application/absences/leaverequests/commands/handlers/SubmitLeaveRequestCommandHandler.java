package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SubmitLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementEmployee;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementEmployeeRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.applicant.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.factory.LeaveRequestFactory;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.applicant.ApplicantId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class SubmitLeaveRequestCommandHandler implements CommandHandler<SubmitLeaveRequestCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveEntitlementEmployeeRepository leaveEntitlementEmployeeRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(SubmitLeaveRequestCommand command) {

        Applicant applicant = employeeRepository.load(new ApplicantId(command.getApplicantId()));

        LeaveEntitlementEmployee leavePrivileges = leaveEntitlementEmployeeRepository.load(new EmployeeId(command.getApplicantId()));
        LeaveRequest leaveRequest = LeaveRequestFactory.create(
                command.getType(), applicant, command.getFrom(), command.getTo());

        if (leavePrivileges.compliant(leaveRequest)) {
            //todo
        }

        applicant.submit(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }
}
