package com.durys.jakub.companymanagement.readmodel.leaverequests;

import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteria;

import java.util.List;

public interface EmployeeLeaveRequestFinder {
    List<EmployeeLeaveRequest> findAll(EmployeeId employeeId, SearchCriteria searchCriteria);
}
