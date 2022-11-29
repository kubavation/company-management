package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
public class LeavePrivileges {

    private final LeaveRequestType leaveRequestType;
    private final EmployeeId employeeId;

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    private Integer daysEntitled;
    private BigDecimal hoursEntitled;

    private Integer daysUsed;
    private BigDecimal hoursUsed;

}
