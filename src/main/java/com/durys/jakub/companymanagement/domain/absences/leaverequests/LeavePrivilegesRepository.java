package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.util.List;

public interface LeavePrivilegesRepository {

    List<LeavePrivileges> load(EmployeeId employeeId);

    LeavePrivileges load(EmployeeId employeeId, LeaveRequestType requestType, LocalDate from, LocalDate to);
}
