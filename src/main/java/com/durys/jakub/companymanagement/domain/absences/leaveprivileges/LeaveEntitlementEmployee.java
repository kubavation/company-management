package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.Collections;
import java.util.List;

@AggregateRoot
public class LeaveEntitlementEmployee implements Employable {

    private final EmployeeId employeeId;
    private List<LeavePrivilege> leavePrivileges;


    public LeaveEntitlementEmployee(EmployeeId employeeId, List<LeavePrivilege> leavePrivileges) {
        this.employeeId = employeeId;
        this.leavePrivileges = leavePrivileges;
    }

    public LeaveEntitlementEmployee(EmployeeId employeeId) {
        this.employeeId = employeeId;
        this.leavePrivileges = Collections.emptyList();
    }

    void grant(LeavePrivilege leavePrivilege) {

    }

    @Override
    public EmployeeId getId() {
        return employeeId;
    }
}
