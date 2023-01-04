package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.DomainEntity;
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
@DomainEntity
class LeavePrivilege {

    private final LeaveType leaveType;
    private final LeavePrivilegesPeriod period;
    private final GrantedPrivileges grantedPrivileges;

    private UtilisedPrivileges utilisedPrivileges;

    LeavePrivilege(LeaveType leaveType, LeavePrivilegesPeriod period, GrantedPrivileges grantedPrivileges, UtilisedPrivileges utilisedPrivileges) {
        this.leaveType = leaveType;
        this.period = period;
        this.grantedPrivileges = grantedPrivileges;
        this.utilisedPrivileges = utilisedPrivileges;
    }

    LeavePrivilege(LeaveType leaveType, LeavePrivilegesPeriod period, GrantedPrivileges grantedPrivileges) {
        this(leaveType, period, grantedPrivileges, new UtilisedPrivileges(BigDecimal.ZERO, BigDecimal.ZERO));
    }

    boolean isEntitledAtDay(LocalDate date) {
        return period.includes(date);
    }


    void recalculate(BigDecimal quantity) {
        utilisedPrivileges = utilisedPrivileges.addDays(quantity); //todo explore domain
    }

}
