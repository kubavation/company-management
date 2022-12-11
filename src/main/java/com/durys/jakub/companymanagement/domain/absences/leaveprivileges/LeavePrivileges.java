package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.RequestedDaysExceedLeavePrivilegesException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
public class LeavePrivileges {

    private final LeaveRequestType leaveRequestType;
    private final EmployeeId employeeId;

    private final LeavePrivilegesPeriod period;
    private final GrantedPrivileges grantedPrivileges;

    public LeavePrivileges(LeaveRequestType leaveRequestType, EmployeeId employeeId, LeavePrivilegesPeriod period, GrantedPrivileges grantedPrivileges) {
        this.leaveRequestType = leaveRequestType;
        this.employeeId = employeeId;
        this.period = period;
        this.grantedPrivileges = grantedPrivileges;
    }


    public void checkCompatibility(LeaveRequestAggregate leaveRequestAggregate) {
        Long numberOfDays = leaveRequestAggregate.getPeriod().numberOfDays();
        if (numberOfDays > grantedPrivileges.getDaysEntitled()) {
            throw new RequestedDaysExceedLeavePrivilegesException();
        }
    }

}
