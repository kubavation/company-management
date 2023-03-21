package com.durys.jakub.companymanagement.readmodel.leaverequests.impl;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequest;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequestFinder;
import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor
public class JpaEmployeeLeaveRequestFinder implements EmployeeLeaveRequestFinder {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeeLeaveRequest> findAll(EmployeeId employeeId, SearchCriteria searchCriteria) {
        return null; //todo
    }
}
