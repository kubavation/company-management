package com.durys.jakub.companymanagement.application.employees.commands.handlers;

import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

@CommandHandling
@Slf4j
@RequiredArgsConstructor
public class EngageEmployeeCommandHandler implements CommandHandler<EngageEmployeeCommand> {

    private final EmployeeRepository employeeRepository;
    private final IdentityProvider identityProvider;
    private final DepartmentProvider departmentProvider;

    @Override
    public void handle(EngageEmployeeCommand command) {

        log.info("handling engage employee command");

        Department department = departmentProvider.find(new DepartmentId(command.departmentId()));

        Employee employee = new Employee(
                new EmployeeId(identityProvider.nextId()),
                new PersonalData(command.firstName(), command.lastName(), command.gender(), command.birthdayDate()),
                department,
                Collections.emptyList());

        employeeRepository.save(employee);
    }
}
