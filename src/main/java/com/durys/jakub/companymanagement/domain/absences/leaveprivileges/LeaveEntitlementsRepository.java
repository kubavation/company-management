package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


public interface LeaveEntitlementsRepository {

    <T extends EmployeeId> LeaveEntitlements load(T employeeId);

    void save(LeaveEntitlements leaveEntitlements);
}
