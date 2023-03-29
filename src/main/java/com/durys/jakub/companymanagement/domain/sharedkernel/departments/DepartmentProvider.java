package com.durys.jakub.companymanagement.domain.sharedkernel.departments;

import com.durys.jakub.companymanagement.domain.employees.vo.DepartmentId;

public interface DepartmentProvider {

    Department find(DepartmentId departmentId);
}
