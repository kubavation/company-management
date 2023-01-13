package com.durys.jakub.companymanagement.domain.sharedkernel.departments;

import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;

public interface DepartmentService {

    Department findById(DepartmentId departmentId);
}
