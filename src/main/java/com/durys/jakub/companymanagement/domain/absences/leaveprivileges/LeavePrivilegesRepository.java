package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


import java.time.LocalDate;
import java.util.List;

public interface LeavePrivilegesRepository {

    <T extends EmployeeId> List<LeavePrivilege> load(T employeeId);

    <T extends EmployeeId> LeavePrivilege load(T employeeId, LeaveRequestType type, LocalDate date);

    void save(LeavePrivilege leavePrivileges);
}
