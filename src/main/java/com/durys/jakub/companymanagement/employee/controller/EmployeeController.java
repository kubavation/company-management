package com.durys.jakub.companymanagement.employee.controller;

import com.durys.jakub.companymanagement.employee.converter.EmployeeMapper;
import com.durys.jakub.companymanagement.employee.model.dto.EmployeeDTO;
import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return employeeMapper.toDTO(employeeService.findAll());
    }
}
