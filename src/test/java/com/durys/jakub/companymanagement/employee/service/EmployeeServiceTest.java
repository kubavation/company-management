package com.durys.jakub.companymanagement.employee.service;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.repository.JpaEmployeeRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private JpaEmployeeRepository jpaEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void findEmployeeById_ShouldReturnEmployee() {
        Employee employee = new Employee(1L, "John", "Doe");
        when(jpaEmployeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        assertEquals(employeeService.findById(1L).getId() , 1L);
    }


    @Test
    void findEmployeeById_shouldThrowException() {
        when(jpaEmployeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> employeeService.findById(1L));
    }

}