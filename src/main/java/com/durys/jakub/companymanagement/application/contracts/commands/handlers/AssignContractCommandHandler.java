package com.durys.jakub.companymanagement.application.contracts.commands.handlers;

import com.durys.jakub.companymanagement.application.contracts.commands.AssignContractCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.contracts.*;
import com.durys.jakub.companymanagement.domain.employees.exception.EmployeeNotExistsException;
import com.durys.jakub.companymanagement.domain.employees.Employee;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@CommandHandling
@RequiredArgsConstructor
public class AssignContractCommandHandler implements CommandHandler<AssignContractCommand> {

    private final EmployeeRepository employeeRepository;
    private final ContractRepository contractRepository;

    @Override
    public void handle(AssignContractCommand command) {

       Employee employee = employeeRepository.load(EmployeeId.from(command.employeeId()));

       if (Objects.isNull(employee)) {
           throw new EmployeeNotExistsException();
       }

       Contract.Builder workInProgress = Contract.Builder
               .instanceOf(ContractType.valueOf(command.contractType()))
                       .withNumber(command.contractNumber())
                       .in(command.from(), command.to())
                       .data()
                            .workingAs(command.position())
                            .earning(command.salary())
                            .workingTime(command.dailyNumberOfHours(), command.dailyNumberOfMinutes())
                            .prepare()
                        .assignTo(employee);


       Contract contract = ContractFactory.prepare(ContractType.valueOf(command.contractType()), workInProgress);

       contractRepository.save(contract);
    }
}
