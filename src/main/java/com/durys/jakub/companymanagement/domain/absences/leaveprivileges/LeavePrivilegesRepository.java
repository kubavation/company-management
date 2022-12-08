package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;


import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


import java.util.List;

public interface LeavePrivilegesRepository {

    <T extends EmployeeId> List<LeavePrivileges> load(T employeeId);
}
