package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLeaveEntitlementsRepository implements LeaveEntitlementsRepository {

    private static final Map<EmployeeId, LeaveEntitlements> DB = new HashMap<>();

    @Override
    public <T extends EmployeeId> LeaveEntitlements load(T leaveEntitlementEmployeeId) {
        return DB.get(leaveEntitlementEmployeeId);
    }

    @Override
    public void save(LeaveEntitlements leaveEntitlementEmployee) {
        DB.put(leaveEntitlementEmployee.employeeId(), leaveEntitlementEmployee);
    }
}
