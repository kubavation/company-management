package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.CancelWorkingTimeRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class CancelWorkingTimeRequestCommandHandler implements CommandHandler<CancelWorkingTimeRequestCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;

    @Override
    public void handle(CancelWorkingTimeRequestCommand command) {
        WorkingTimeRequest request = workingTimeRequestRepository.load(command.requestId());
        request.markAsCancelled();
        workingTimeRequestRepository.save(request);
    }
}
