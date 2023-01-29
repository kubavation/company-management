package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SendLeaveRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.notificationservice.client.api.NotificationApiClient;
import com.durys.jakub.notificationservice.client.model.NotificationDTO;
import com.durys.jakub.notificationservice.client.model.NotificationType;
import com.durys.jakub.notificationservice.client.model.TenantId;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@CommandHandling
@RequiredArgsConstructor
public class SendLeaveRequestForAcceptationCommandHandler implements CommandHandler<SendLeaveRequestForAcceptationCommand> {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final NotificationApiClient notificationClient;

    //todo acceptant repository / explore domain

    @Override
    public void handle(SendLeaveRequestForAcceptationCommand command) {

        LeaveRequest leaveRequest = leaveRequestRepository.load(new LeaveRequestId(command.getLeaveRequestId()));
        Applicant applicant = employeeRepository.load(leaveRequest.getApplicantId());
        Acceptant acceptant = employeeRepository.load(new AcceptantId(command.getAcceptantId()));

        applicant.sendToAcceptant(leaveRequest, acceptant);

        leaveRequestRepository.save(leaveRequest);

        notificationClient.publish(
                new NotificationDTO(new TenantId(acceptant.tenantId().val()),
                        "Leave request for acceptation",
                        "Leave request for acceptation", List.of(NotificationType.APP))
            );

    }
}
