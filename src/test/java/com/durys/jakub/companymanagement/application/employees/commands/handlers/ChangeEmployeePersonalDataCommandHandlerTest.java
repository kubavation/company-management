package com.durys.jakub.companymanagement.application.employees.commands.handlers;

import com.durys.jakub.companymanagement.application.employees.commands.ChangeEmployeePersonalDataCommand;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.infrastructure.employees.HashMapEmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ChangeEmployeePersonalDataCommandHandlerTest {

    EmployeeRepository employeeRepository = new HashMapEmployeeRepository();
    ChangeEmployeePersonalDataCommandHandler commandHandler = new ChangeEmployeePersonalDataCommandHandler(employeeRepository);

    @BeforeEach
    void initEmployee() {

        UUID employeeId = UUID.fromString("47db3704-a571-11ed-b9df-0242ac120003");

        employeeRepository.save(
                new Employee(
                        new EmployeeId(employeeId),
                        new PersonalData("John", "Doe", "MAN", LocalDate.of(1990,1,1)),
                        new Department(new DepartmentId("1"), "DS", "DS", "/DS"),
                        Collections.emptyList()
                )
        );
    }

    @Test
    void changeEmployeePersonalData_shouldSuccessfullyChangeDate() {

        UUID employeeId = UUID.fromString("47db3704-a571-11ed-b9df-0242ac120003");
        ChangeEmployeePersonalDataCommand command = new ChangeEmployeePersonalDataCommand(
                employeeId, "John", "NoDoe", "MAN", LocalDate.of(1990,1,1)
        );

        commandHandler.handle(command);
        Employee employee = employeeRepository.load(new EmployeeId(employeeId));
        assertEquals("NoDoe John", employee.name());
    }

}