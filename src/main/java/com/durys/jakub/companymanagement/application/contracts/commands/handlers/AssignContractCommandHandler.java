package com.durys.jakub.companymanagement.application.contracts.commands.handlers;

import com.durys.jakub.companymanagement.application.contracts.commands.AssignContractCommand;
import com.durys.jakub.companymanagement.commons.vo.Currency;
import com.durys.jakub.companymanagement.commons.vo.Money;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.contracts.*;
import com.durys.jakub.companymanagement.domain.contracts.vo.*;
import com.durys.jakub.companymanagement.domain.employees.exception.EmployeeNotExistsException;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@CommandHandling
@RequiredArgsConstructor
public class AssignContractCommandHandler implements CommandHandler<AssignContractCommand> {

    private final EmployeeRepository employeeRepository;
    private final ContractRepository contractRepository;

    @Override
    public void handle(AssignContractCommand command) {

       Employee employee = employeeRepository.load(EmployeeId.from(command.getEmployeeId()));

       if (Objects.isNull(employee)) {
           throw new EmployeeNotExistsException();
       }


       Contract.Builder workInProgress = Contract.Builder
               .instance(ContractType.valueOf(command.getContractType()), new ContractId(UUID.randomUUID()))
                       .withNumber(command.getContractNumber())
                       .withContractData(
                           new ContractData(
                                   new Position(command.getPosition()),
                                   Salary.withDefaultCurrencyOf(command.getSalary()),
                                   new WorkingTime(
                                           DailyHourNumber.of(command.getDailyNumberOfHours(), command.getDailyNumberOfMinutes()),
                                           BillingPeriod.valueOf(command.getBillingPeriod()))))
                        .assignTo(employee);

       Contract contract = ContractFactory.prepare(
               ContractType.valueOf(command.getContractType()),
               workInProgress);


       contractRepository.save(contract);
    }
}
