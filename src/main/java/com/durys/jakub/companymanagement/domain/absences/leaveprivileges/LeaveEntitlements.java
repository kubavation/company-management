package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.LeavePrivilegeIsAlreadyEntitledException;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.vo.LeaveType;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import io.vavr.control.Either;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AggregateRoot
public class LeaveEntitlements {

    private final EmployeeId employeeId;
    private List<LeavePrivilege> leavePrivileges;


    public LeaveEntitlements(EmployeeId employeeId, List<LeavePrivilege> leavePrivileges) {
        this.employeeId = employeeId;
        this.leavePrivileges = leavePrivileges;

        if (Objects.isNull(leavePrivileges)) {
            this.leavePrivileges = Collections.emptyList();
        }
    }

    public LeaveEntitlements(EmployeeId employeeId) {
        this.employeeId = employeeId;
        this.leavePrivileges = Collections.emptyList();
    }

    public void add(LeaveType leaveType, LocalDate from, LocalDate to, BigDecimal days, BigDecimal hours) {

        if (leavePrivilegeAlreadyEntitled(leaveType, new LeavePrivilegesPeriod(from, to))) {
            throw new LeavePrivilegeIsAlreadyEntitledException();
        }

        LeavePrivilege leavePrivilege = new LeavePrivilege(leaveType, new LeavePrivilegesPeriod(from, to), new GrantedPrivileges(days, hours));
        leavePrivileges.add(leavePrivilege);
    }


    public BigDecimal daysEntitled(LeaveType leaveType,  LocalDate statusAs) {
        return getPrivilege(leaveType, statusAs)
                .map(privilege -> privilege.getGrantedPrivileges().getDaysEntitled())
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal hoursEntitled(LeaveType leaveType,  LocalDate statusAs) {
        return getPrivilege(leaveType, statusAs)
                .map(privilege -> privilege.getGrantedPrivileges().getHoursEntitled())
                .orElse(BigDecimal.ZERO);
    }


    private Optional<LeavePrivilege> getPrivilege(LeaveType leaveType, LocalDate statusAs) {
        return leavePrivileges.stream()
                .filter(privilege -> privilege.getLeaveType().equals(leaveType))
                .filter(privilege -> privilege.isEntitledAtDay(statusAs))
                .findFirst();
    }

    private boolean leavePrivilegeAlreadyEntitled(LeaveType leaveType, LeavePrivilegesPeriod period) {

       return getPrivilege(leaveType, period.getDateFrom()).isPresent()
               || getPrivilege(leaveType, period.getDateTo()).isPresent();
    }

}
