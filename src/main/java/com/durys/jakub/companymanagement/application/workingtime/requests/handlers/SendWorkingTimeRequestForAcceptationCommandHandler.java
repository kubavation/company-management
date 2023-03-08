package com.durys.jakub.companymanagement.application.workingtime.requests.handlers;

import com.durys.jakub.companymanagement.application.workingtime.requests.SendWorkingTimeRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequest;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class SendWorkingTimeRequestForAcceptationCommandHandler implements CommandHandler<SendWorkingTimeRequestForAcceptationCommand> {

    private final WorkingTimeRequestRepository workingTimeRequestRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(SendWorkingTimeRequestForAcceptationCommand command) {
        WorkingTimeRequest request = workingTimeRequestRepository.load(command.requestId());
        Employee acceptant = employeeRepository.load(command.acceptantId());

        request.sendTo(acceptant);

        workingTimeRequestRepository.save(request);
    }
}
