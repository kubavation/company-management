package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AggregateRoot
public class LeaveEntitlementEmployee implements Employable {

    private final EmployeeId employeeId;
    private List<LeavePrivilege> leavePrivileges;

    @Override
    public EmployeeId getId() {
        return employeeId;
    }

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

    public void grantWith(LeaveType leaveType, LeavePrivilegesPeriod period, GrantedPrivileges privileges) {
        LeavePrivilege leavePrivilege = new LeavePrivilege(leaveType, period, privileges);
        leavePrivileges.add(leavePrivilege);
    }


    private Optional<LeavePrivilege> getPrivilege(LeaveType leaveType, LocalDate statusAs) {
        return leavePrivileges.stream()
                .filter(privilege -> privilege.getLeaveType().equals(leaveType))
                .filter(privilege -> privilege.isEntitledAtDay(statusAs))
                .findFirst();
    }

    private boolean leavePrivilegeAlreadyEntitled(LeaveType leaveType, LeavePrivilegesPeriod period) {

       if (getPrivilege(leaveType, period.getDateFrom()).isPresent()) {
           throw new RuntimeException();
       }

        if (getPrivilege(leaveType, period.getDateTo()).isPresent()) {
            throw new RuntimeException();
        }
    }

}
