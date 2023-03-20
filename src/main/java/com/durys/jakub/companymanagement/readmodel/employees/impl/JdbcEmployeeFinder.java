package com.durys.jakub.companymanagement.readmodel.employees.impl;

import com.durys.jakub.companymanagement.readmodel.employees.EmployeeFinder;
import com.durys.jakub.companymanagement.readmodel.employees.EmployeeWithPersonalData;
import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class JdbcEmployeeFinder implements EmployeeFinder {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeeWithPersonalData> findEmployeesWithPersonalData(SearchCriteria criteria) {
        return Collections.emptyList();
    }
}
