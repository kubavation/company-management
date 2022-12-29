package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementEmployee;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementEmployeeRepository;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLeaveEntitlementEmployeeRepository implements LeaveEntitlementEmployeeRepository {

    private static final Map<EmployeeId, LeaveEntitlementEmployee> DB = new HashMap<>();

    @Override
    public <T extends EmployeeId> LeaveEntitlementEmployee load(T leaveEntitlementEmployeeId) {
        return DB.get(leaveEntitlementEmployeeId);
    }

    @Override
    public void save(LeaveEntitlementEmployee leaveEntitlementEmployee) {
        DB.put(leaveEntitlementEmployee.getId(), leaveEntitlementEmployee);
    }
}
