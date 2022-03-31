package com.durys.jakub.companymanagement.employee.controller;

import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
}
