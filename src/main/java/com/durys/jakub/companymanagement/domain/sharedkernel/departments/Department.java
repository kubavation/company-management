package com.durys.jakub.companymanagement.domain.sharedkernel.departments;

import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;

public record Department(DepartmentId departmentId, String name, String shortcut, String path) {
}
