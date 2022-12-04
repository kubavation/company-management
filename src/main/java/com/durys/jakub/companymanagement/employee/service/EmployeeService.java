package com.durys.jakub.companymanagement.employee.service;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.repository.JpaEmployeeRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    public Employee findById(Long id) {
        return jpaEmployeeRepository.findById(id)
                .orElseThrow(EntityNotFoundException.of(Employee.class, id));
    }

    public List<Employee> findAll() {
        return jpaEmployeeRepository.findAll();
    }
}
