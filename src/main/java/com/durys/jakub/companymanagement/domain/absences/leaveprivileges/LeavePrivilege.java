package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.DailyLeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.HourlyLeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.RequestedDaysExceedLeavePrivilegesException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class LeavePrivilege {

    private final LeaveRequestType leaveRequestType;
    private final LeavePrivilegesPeriod period;
    private final GrantedPrivileges grantedPrivileges;

    LeavePrivilege(LeaveRequestType leaveRequestType, LeavePrivilegesPeriod period, GrantedPrivileges grantedPrivileges) {
        this.leaveRequestType = leaveRequestType;
        this.period = period;
        this.grantedPrivileges = grantedPrivileges;
    }


    public void checkCompatibility(LeaveRequest leaveRequest) {

        if (!leaveRequestType.equals(leaveRequest.getRequestType())) {
            throw new RuntimeException("Invalid requestType param");
        }

        BigDecimal quantity = leaveRequest.getPeriod().getQuantity();

        if (leaveRequest instanceof DailyLeaveRequest && quantity.compareTo(grantedPrivileges.getDaysEntitled()) > 0) {
            throw new RequestedDaysExceedLeavePrivilegesException();
        }

        if (leaveRequest instanceof HourlyLeaveRequest && quantity.compareTo(grantedPrivileges.getHoursEntitled()) > 0) {
            throw new RequestedDaysExceedLeavePrivilegesException();
        }


    }

}
