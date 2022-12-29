package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@AggregateRoot
public class LeaveEntitlementEmployee implements Employable {

    private final EmployeeId employeeId;
    private List<LeavePrivilege> leavePrivileges;


    public LeaveEntitlementEmployee(EmployeeId employeeId, List<LeavePrivilege> leavePrivileges) {
        this.employeeId = employeeId;
        this.leavePrivileges = leavePrivileges;

        if (Objects.isNull(leavePrivileges)) {
            this.leavePrivileges = Collections.emptyList();
        }

    }

    public LeaveEntitlementEmployee(EmployeeId employeeId) {
        this.employeeId = employeeId;
        this.leavePrivileges = Collections.emptyList();
    }

    public void grantWith(LeaveRequestType leaveRequestType, LeavePrivilegesPeriod period, GrantedPrivileges privileges) {
        LeavePrivilege leavePrivilege = new LeavePrivilege(leaveRequestType, period, privileges);
        leavePrivileges.add(leavePrivilege);
    }

    @Override
    public EmployeeId getId() {
        return employeeId;
    }

}
