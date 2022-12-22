package com.durys.jakub.companymanagement.application.employees;

import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.vo.EmployeePersonalData;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class EmployeesApplicationService {

    private final EmployeeRepository employeeRepository;

    public void employ(String firstName, String lastName, String gender) {
        Employee employee = new Employee(new EmployeeId(UUID.randomUUID()), new EmployeePersonalData(firstName, lastName, gender));
        employeeRepository.save(employee);
    }

}
