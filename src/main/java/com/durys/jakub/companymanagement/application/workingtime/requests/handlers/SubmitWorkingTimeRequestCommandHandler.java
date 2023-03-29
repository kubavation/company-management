package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.SubmitWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@CommandHandling
@RequiredArgsConstructor
public class SubmitWorkingTimeRequestCommandHandler implements CommandHandler<SubmitWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(SubmitWorkingTimeRequestCommand command) {

        Author author = Author.from(employeeRepository.load(command.employeeId()));

        WorkInProgress workInProgress = WorkingTimeRequest
                .builder(new WorkingTimeRequestId(UUID.randomUUID()))
                    .ofType(command.type())
                    .author(command.employeeId())
                    .at(command.day())
                        .from(command.from())
                        .to(command.to())
                    .save();

        SubmittedWorkingTimeRequest submittedRequest = author.submit(workInProgress);

        workingTimeRequestRepository.save(submittedRequest);
    }
}
