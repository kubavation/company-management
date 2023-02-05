package com.durys.jakub.companymanagement.application.employees.commands.handlers;

import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import com.durys.jakub.companymanagement.infrastructure.departments.RestDepartmentProvider;
import com.durys.jakub.companymanagement.infrastructure.employees.HashMapEmployeeRepository;
import com.durys.jakub.companymanagement.infrastructure.shared.identity.UUIDIdentityProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class EngageEmployeeCommandHandlerTest {

     EmployeeRepository employeeRepository = new HashMapEmployeeRepository();
     IdentityProvider identityProvider = Mockito.mock(UUIDIdentityProvider.class);
     DepartmentProvider departmentProvider = Mockito.mock(RestDepartmentProvider.class);

     EngageEmployeeCommandHandler commandHandler = new EngageEmployeeCommandHandler(employeeRepository, identityProvider, departmentProvider);

     @Test
     void engageEmployee_shouldSuccessfullyEngageEmployee() {

         UUID expectedId = UUID.randomUUID();
         EngageEmployeeCommand command = new EngageEmployeeCommand("John", "Doe", "MAN", LocalDate.now(), "123");

         when(departmentProvider.find(new DepartmentId("123")))
                 .thenReturn(new Department(new DepartmentId("123"), "Dep1", "D1", "/D1"));
         when(identityProvider.nextId()).thenReturn(expectedId);

         commandHandler.handle(command);

         Employee engagedEmployee = employeeRepository.load(new EmployeeId(expectedId));
         assertEquals(expectedId, engagedEmployee.employeeId().value());
     }


    @Test
    void engageEmployee_withInvalidDepartmentId_shouldThrowException() {

        UUID expectedId = UUID.randomUUID();
        EngageEmployeeCommand command = new EngageEmployeeCommand("John", "Doe", "MAN", LocalDate.now(), "123");

        when(departmentProvider.find(new DepartmentId("123")))
                .thenReturn(null);
        when(identityProvider.nextId()).thenReturn(expectedId);

        Exception exception = assertThrows(RuntimeException.class, () -> commandHandler.handle(command));
        assertEquals("Invalid departmentId", exception.getMessage());
    }

}