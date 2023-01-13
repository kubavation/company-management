package com.durys.jakub.companymanagement.infrastructure.departments;

import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import org.springframework.stereotype.Component;

@Component
public class RestDepartmentProvider implements DepartmentProvider {


    @Override
    public Department find(DepartmentId departmentId) {
        return null;
    }
}
