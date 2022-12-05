package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivileges;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HashMapLeavePrivilegesRepository implements LeavePrivilegesRepository {

    private static final HashMap<EmployeeId, List<LeavePrivileges>> DB = new HashMap<>();

    @Override
    public List<LeavePrivileges> load(EmployeeId employeeId) {
        return DB.get(employeeId);
    }
}
