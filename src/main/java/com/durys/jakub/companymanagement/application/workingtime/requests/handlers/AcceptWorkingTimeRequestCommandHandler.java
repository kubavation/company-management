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

        SentForAcceptationWorkingTimeRequest request
                = WorkingTimeRequestService.asAcceptable(workingTimeRequestRepository.load(command.requestId()));

        Acceptant acceptant = request.acceptant();
        AcceptedWorkingTimeRequest acceptedRequest = acceptant.accept(request);

        workingTimeRequestRepository.save(acceptedRequest);
    }
}
