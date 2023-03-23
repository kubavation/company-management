package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.CancelWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class CancelWorkingTimeRequestCommandHandler implements CommandHandler<CancelWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;

    @Override
    public void handle(CancelWorkingTimeRequestCommand command) {

        RequestInWorkflow request = workingTimeRequestRepository.load(command.requestId());
        
        Author author = request.author();

        CancelledWorkingTimeRequest canceledRequest = author.cancel(request);

        workingTimeRequestRepository.save(canceledRequest);
    }
}
