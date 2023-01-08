package com.durys.jakub.companymanagement.application.contracts.commands.handlers;

import com.durys.jakub.companymanagement.application.contracts.commands.AssignContractCommand;
import com.durys.jakub.companymanagement.commons.vo.Currency;
import com.durys.jakub.companymanagement.commons.vo.Money;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.domain.contracts.ContractType;
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


       Contract contract = Contract.Builder
               .withId(new ContractId(UUID.randomUUID()))
                       .withNumber(command.getContractNumber())
                       .withContractData(
                           new ContractData(
                                   new Position(command.getPosition()),
                                   new Salary(new Money(command.getSalary()), Currency.EURO),
                                   new WorkingTime(
                                           DailyHourNumber.of(command.getDailyNumberOfHours(), command.getDailyNumberOfMinutes()),
                                           BillingPeriod.valueOf(command.getBillingPeriod())),
                                   ContractType.valueOf(command.getContractType()))
                       )
               .assignTo(employee);


       contractRepository.save(contract);
    }
}
