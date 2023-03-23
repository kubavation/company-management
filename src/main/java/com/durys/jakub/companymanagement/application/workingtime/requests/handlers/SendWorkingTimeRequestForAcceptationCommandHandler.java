package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.SendWorkingTimeRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class SendWorkingTimeRequestForAcceptationCommandHandler implements CommandHandler<SendWorkingTimeRequestForAcceptationCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(SendWorkingTimeRequestForAcceptationCommand command) {

        RequestInWorkflow request = workingTimeRequestRepository.load(command.requestId());

        if (!(request instanceof SubmittedWorkingTimeRequest workingTimeRequest)) {
            throw new UnsupportedOperationException();
        }

        Author author = workingTimeRequest.author();

        Acceptant acceptant = Acceptant.from(employeeRepository.load(command.acceptantId()));

        SentForAcceptationWorkingTimeRequest sentRequest = author.send(workingTimeRequest).to(acceptant);

        workingTimeRequestRepository.save(sentRequest);
    }
}
