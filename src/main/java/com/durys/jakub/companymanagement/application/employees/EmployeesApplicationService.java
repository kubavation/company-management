package com.durys.jakub.companymanagement.application.employees;

import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.vo.EmployeePersonalData;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EmployeesApplicationService {

    private final EmployeeRepository employeeRepository;

    private final IdentityProvider identityProvider;

    public void engage(String firstName, String lastName, String gender) {
        Employee employee = new Employee(new EmployeeId(identityProvider.nextId()), new EmployeePersonalData(firstName, lastName, gender));
        employeeRepository.save(employee);
    }

}
