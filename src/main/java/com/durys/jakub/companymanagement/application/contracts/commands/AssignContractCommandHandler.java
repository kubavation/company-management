package com.durys.jakub.companymanagement.application.contracts.commands;

import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class AssignContractCommandHandler implements CommandHandler<AssignContractCommand> {

    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(AssignContractCommand assignContractCommand) {
        //todo
    }
}
