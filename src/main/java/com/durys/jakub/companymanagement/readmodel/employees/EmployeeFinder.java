package com.durys.jakub.companymanagement.readmodel.employees;

import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteria;

import java.util.List;

public interface EmployeeFinder {
    List<EmployeeWithPersonalData> findEmployeesWithPersonalData(SearchCriteria criteria);
}
