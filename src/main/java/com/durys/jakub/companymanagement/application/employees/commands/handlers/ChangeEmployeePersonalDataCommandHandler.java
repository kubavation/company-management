package com.durys.jakub.companymanagement.application.employees.commands.handlers;

import com.durys.jakub.companymanagement.application.employees.commands.ChangeEmployeePersonalDataCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.Employee;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.vo.PersonalData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@CommandHandling
@Slf4j
@RequiredArgsConstructor
public class ChangeEmployeePersonalDataCommandHandler implements CommandHandler<ChangeEmployeePersonalDataCommand> {

    private final EmployeeRepository employeeRepository;

    @Override
    public void handle(ChangeEmployeePersonalDataCommand command) {

        log.info("handling ChangeEmployeePersonalDataCommand {}", command);

        Employee employee = employeeRepository.load(new EmployeeId(command.employeeId()));

        Objects.requireNonNull(employee);

        employee.changePersonalData(
                new PersonalData(command.firstName(), command.lastName(), command.gender(), command.birthdayDate()));

        employeeRepository.save(employee);
    }
}
