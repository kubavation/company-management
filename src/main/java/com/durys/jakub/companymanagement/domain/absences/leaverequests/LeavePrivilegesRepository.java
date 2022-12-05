package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


import java.util.List;

public interface LeavePrivilegesRepository {

    List<LeavePrivileges> load(EmployeeId employeeId);
}
