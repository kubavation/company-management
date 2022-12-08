package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.RequestedDaysExceedLeavePrivilegesException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class LeavePrivileges {

    private final LeaveRequestType leaveRequestType;
    private final EmployeeId employeeId;

    private LeavePrivilegesPeriod period;

    private Integer daysEntitled;
    private BigDecimal hoursEntitled;

    private Integer daysUsed;
    private BigDecimal hoursUsed;


    public void checkCompatibility(LeaveRequestAggregate leaveRequest) {

        if (leaveRequest.getPeriod().numberOfDays() > daysAvailable()) {
            throw new RequestedDaysExceedLeavePrivilegesException();
        }

    }

    public Integer daysAvailable() {
        return daysEntitled - daysUsed;
    }


    public boolean inPrivileges(LeaveRequestPeriod period, LeaveRequestType type) {
        return period.getDateTo().isAfter(period.getDateFrom()) && period.getDateTo().isBefore(period.getDateTo()) && type.equals(leaveRequestType);
    }

}