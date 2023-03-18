package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.AcceptWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.AcceptedWorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.RequestInWorkflow;
import com.durys.jakub.companymanagement.domain.workingtime.requests.SentForAcceptationWorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
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

        AcceptedWorkingTimeRequest rejectedRequest = workingTimeRequest.accept();
        workingTimeRequestRepository.save(rejectedRequest);
    }
}
