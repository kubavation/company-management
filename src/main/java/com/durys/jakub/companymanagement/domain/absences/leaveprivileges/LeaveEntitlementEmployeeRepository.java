package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


public interface LeaveEntitlementEmployeeRepository {

    <T extends EmployeeId> LeaveEntitlementEmployee load(T leaveEntitlementEmployeeId);

    void save(LeaveEntitlementEmployee leaveEntitlementEmployee);
}
