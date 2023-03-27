package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.RejectWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.*;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class RejectWorkingTimeRequestCommandHandler implements CommandHandler<RejectWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;

    @Override
    public void handle(RejectWorkingTimeRequestCommand command) {

        SentForAcceptationWorkingTimeRequest request = WorkingTimeRequestService.asRejectable(workingTimeRequestRepository.load(command.requestId()));

        Acceptant acceptant = request.acceptant();

        RejectedWorkingTimeRequest rejectedRequest = acceptant.reject(request);

        workingTimeRequestRepository.save(rejectedRequest);
    }
}
