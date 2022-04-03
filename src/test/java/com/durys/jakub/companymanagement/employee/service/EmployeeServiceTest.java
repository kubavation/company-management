package com.durys.jakub.companymanagement.employee.service;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.repository.EmployeeRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;


    @Test
    public void findEmployeeById_ShouldReturnEmployee() {
        Employee employee = new Employee(1L, "John", "Doe");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Assertions.assertTrue(employeeRepository.findById(1L).isPresent());
    }


    @Test
    public void findEmployeeById_shouldThrowException() {
        when(employeeRepository.findById(1L)).thenThrow(EntityNotFoundException.class);

        Assertions.assertThrows(EntityNotFoundException.class,
                () -> employeeRepository.findById(1L));
    }

}