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
        RequestInWorkflow request = workingTimeRequestRepository.load(command.requestId());

        if (!(request instanceof SentForAcceptationWorkingTimeRequest workingTimeRequest)) {
            throw new UnsupportedOperationException();
        }

        RejectedWorkingTimeRequest rejectedRequest = workingTimeRequest.reject();
        workingTimeRequestRepository.save(rejectedRequest);
    }
}
