package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


import java.time.LocalDate;
import java.util.List;

public interface LeavePrivilegesRepository {

    <T extends EmployeeId> List<LeavePrivileges> load(T employeeId);

    <T extends EmployeeId> LeavePrivileges load(T employeeId, LeaveRequestType type, LocalDate date);

    void save(LeavePrivileges leavePrivileges);
}
