package com.durys.jakub.companymanagement.readmodel.leaverequests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.List;

public interface EmployeeLeaveRequestFinder {
    List<EmployeeLeaveRequest> findAll(EmployeeId employeeId);
}
