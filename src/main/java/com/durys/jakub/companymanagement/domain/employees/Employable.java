package com.durys.jakub.companymanagement.domain.employees;

import com.durys.jakub.companymanagement.domain.sharedkernel.TenantId;

public interface Employable {
    EmployeeId employeeId();
    TenantId tenantId();
}
