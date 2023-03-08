package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.AcceptWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.application.workingtime.requests.CancelWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class AcceptWorkingTimeRequestCommandHandler implements CommandHandler<AcceptWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;

    @Override
    public void handle(AcceptWorkingTimeRequestCommand command) {
        WorkingTimeRequest request = workingTimeRequestRepository.load(command.requestId());
        request.markAsAccepted();
        workingTimeRequestRepository.save(request);
    }
}
