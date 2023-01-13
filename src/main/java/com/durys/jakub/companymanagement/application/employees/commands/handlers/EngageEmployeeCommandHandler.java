package com.durys.jakub.companymanagement.application.employees.commands.handlers;

import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import lombok.RequiredArgsConstructor;

@CommandHandling
@RequiredArgsConstructor
public class EngageEmployeeCommandHandler implements CommandHandler<EngageEmployeeCommand> {

    private final EmployeeRepository employeeRepository;
    private final IdentityProvider identityProvider;

    @Override
    public void handle(EngageEmployeeCommand command) {

        Employee employee = new Employee(identityProvider.nextId(), new PersonalData(
            command.firstName(), command.lastName(), command.gender(), command.birthdayDate()), null); //todo

        employeeRepository.save(employee);
    }
}
