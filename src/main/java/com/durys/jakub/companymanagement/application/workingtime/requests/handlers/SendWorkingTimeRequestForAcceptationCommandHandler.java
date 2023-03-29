package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.SendWorkingTimeRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class SendWorkingTimeRequestForAcceptationCommandHandler implements CommandHandler<SendWorkingTimeRequestForAcceptationCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(SendWorkingTimeRequestForAcceptationCommand command) {

        SubmittedWorkingTimeRequest request = WorkingTimeRequestService.asSendable(workingTimeRequestRepository.load(command.requestId()));

        Author author = request.author();

        Acceptant acceptant = Acceptant.from(employeeRepository.load(command.acceptantId()));

        SentForAcceptationWorkingTimeRequest sentRequest = author.send(request).to(acceptant);

        workingTimeRequestRepository.save(sentRequest);
    }
}
