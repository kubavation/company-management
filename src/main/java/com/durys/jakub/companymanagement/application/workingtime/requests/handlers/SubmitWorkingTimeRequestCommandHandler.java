package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.SubmitWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.SubmittedWorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@CommandHandling
@RequiredArgsConstructor
public class SubmitWorkingTimeRequestCommandHandler implements CommandHandler<SubmitWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;

    @Override
    public void handle(SubmitWorkingTimeRequestCommand command) {

        SubmittedWorkingTimeRequest request = WorkingTimeRequest
                .builder(new WorkingTimeRequestId(UUID.randomUUID()))
                    .ofType(command.type())
                    .author(command.employeeId())
                    .at(command.day())
                        .from(command.from())
                        .to(command.to())
                    .submit();

        workingTimeRequestRepository.save(request);
    }
}
