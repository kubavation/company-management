package com.durys.jakub.companymanagement.application.employees;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.infrastructure.employees.EmployeesConfiguration;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesApplicationServiceTest {

    private final EmployeesConfiguration employeesConfiguration = new EmployeesConfiguration();
    private final EmployeeRepository employeeRepository = employeesConfiguration.hashMapEmployeeRepository();
    private final EmployeesApplicationService employeesApplicationService = new EmployeesConfiguration().employeesApplicationService(employeeRepository);


    

}