package com.durys.jakub.companymanagement.domain.sharedkernel.departments;

import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;

public interface DepartmentProvider {

    Department find(DepartmentId departmentId);
}
