package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SendLeaveRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class SendLeaveRequestForAcceptationCommandHandler implements CommandHandler<SendLeaveRequestForAcceptationCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    //todo fix
    //private final NotificationApiClient notificationClient;

    @Override
    public void handle(SendLeaveRequestForAcceptationCommand command) {

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.leaveRequestId()));
        Applicant applicant = employeeRepository.load(leaveRequest.getApplicantId());
        Acceptant acceptant = employeeRepository.load(new AcceptantId(command.acceptantId()));

        applicant.sendToAcceptant(leaveRequest, acceptant);

        leaveRequestRepository.save(leaveRequest);

        //todo fix
//        notificationClient.publish(
//                new NotificationDTO(new TenantId(acceptant.tenantId().val()),
//                        "Leave request for acceptation",
//                        "Leave request for acceptation",
//                        List.of(NotificationType.APP))
//            );

    }
}
