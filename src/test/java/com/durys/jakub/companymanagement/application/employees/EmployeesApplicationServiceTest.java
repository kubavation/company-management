package com.durys.jakub.companymanagement.application.employees;

import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.application.employees.commands.handlers.EngageEmployeeCommandHandler;
import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import com.durys.jakub.companymanagement.infrastructure.departments.RestDepartmentProvider;
import com.durys.jakub.companymanagement.infrastructure.employees.EmployeesConfiguration;
import com.durys.jakub.companymanagement.infrastructure.shared.identity.UUIDIdentityProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
class EmployeesApplicationServiceTest {

    private final EmployeesConfiguration employeesConfiguration = new EmployeesConfiguration();


    private final EmployeeRepository employeeRepository = employeesConfiguration.hashMapEmployeeRepository();

    private final IdentityProvider identityProvider = Mockito.mock(UUIDIdentityProvider.class);
    private final DepartmentProvider departmentProvider = Mockito.mock(RestDepartmentProvider.class);

    private final EngageEmployeeCommandHandler engageEmployeeCommandHandler = new EngageEmployeeCommandHandler(
            employeeRepository, identityProvider, departmentProvider);

    @Test
    void employPerson_shouldSuccessfullyCreateEmployee() {
        final UUID nextId = UUID.randomUUID();
        EngageEmployeeCommand command = new EngageEmployeeCommand("Dave", "James", "MAN",
                LocalDate.of(1990, 1, 1), UUID.randomUUID().toString());

        when(identityProvider.nextId()).thenReturn(nextId);

        engageEmployeeCommandHandler.handle(command);
        Employee employee = employeeRepository.load(new EmployeeId(nextId));

        assertEquals("James Dave", employee.name());
    }


}