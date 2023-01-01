package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.vo.LeaveType;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.DailyLeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.HourlyLeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.RequestedDaysExceedLeavePrivilegesException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@ValueObject
class LeavePrivilege {

    private final LeaveType leaveType;
    private final LeavePrivilegesPeriod period;
    private final GrantedPrivileges grantedPrivileges;

    LeavePrivilege(LeaveType leaveType, LeavePrivilegesPeriod period, GrantedPrivileges grantedPrivileges) {
        this.leaveType = leaveType;
        this.period = period;
        this.grantedPrivileges = grantedPrivileges;
    }

    boolean isEntitledAtDay(LocalDate date) {
        return period.includes(date);
    }

    public void checkCompatibility(LeaveRequest leaveRequest) {

        BigDecimal quantity = leaveRequest.getPeriod().getQuantity();

        if (leaveRequest instanceof DailyLeaveRequest && quantity.compareTo(grantedPrivileges.getDaysEntitled()) > 0) {
            throw new RequestedDaysExceedLeavePrivilegesException();
        }

        if (leaveRequest instanceof HourlyLeaveRequest && quantity.compareTo(grantedPrivileges.getHoursEntitled()) > 0) {
            throw new RequestedDaysExceedLeavePrivilegesException();
        }

    }

}
