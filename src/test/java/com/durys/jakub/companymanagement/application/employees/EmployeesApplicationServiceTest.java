package com.durys.jakub.companymanagement.application.employees;

import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.infrastructure.employees.EmployeesConfiguration;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



class EmployeesApplicationServiceTest {

    private final EmployeesConfiguration employeesConfiguration = new EmployeesConfiguration();


    private final EmployeeRepository employeeRepository = employeesConfiguration.hashMapEmployeeRepository();


    private IdentityProvider identityProvider;

    private EmployeesApplicationService employeesApplicationService = employeesConfiguration.employeesApplicationService(employeeRepository, identityProvider);


    @Test
    void employPerson_shouldSuccessfullyCreateEmployee() {

        final UUID nextId = UUID.randomUUID();


        employeesApplicationService.employ("Dave", "James", "MAN");

        Employee employee = employeeRepository.load(new EmployeeId(nextId));

        assertEquals("James Dave", employee.name());
    }


}