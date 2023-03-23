package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.AcceptWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class AcceptWorkingTimeRequestCommandHandler implements CommandHandler<AcceptWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;

    @Override
    public void handle(AcceptWorkingTimeRequestCommand command) {

        RequestInWorkflow request = workingTimeRequestRepository.load(command.requestId());

        if (!(request instanceof SentForAcceptationWorkingTimeRequest workingTimeRequest)) {
            throw new UnsupportedOperationException();
        }

        Acceptant acceptant = workingTimeRequest.acceptant();

        AcceptedWorkingTimeRequest acceptedRequest = acceptant.accept(workingTimeRequest);

        workingTimeRequestRepository.save(acceptedRequest);
    }
}
