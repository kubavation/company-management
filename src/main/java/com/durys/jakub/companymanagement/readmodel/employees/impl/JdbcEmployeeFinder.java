package com.durys.jakub.companymanagement.readmodel.employees.impl;

import com.durys.jakub.companymanagement.readmodel.employees.EmployeeFinder;
import com.durys.jakub.companymanagement.readmodel.employees.EmployeeWithPersonalData;
import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class JdbcEmployeeFinder implements EmployeeFinder {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeeWithPersonalData> findEmployeesWithPersonalData(SearchCriteria criteria) {

        String sql = "SELECT e.id employeeId, pd.first_name firstName, pd.last_name lastName," +
                "pd.gender gender, pd.birthday_date birthdayDate," +
                "d.department_id departmentId, d.department_name departmentName," +
                "d.department_shortcut departmentShortcut, d.department_path departmentPath" +
                " FROM CM_EMPLOYEE e" +
                " INNER JOIN CM_EMPLOYEE_PERSONAL_DATA pd on pd.employee_id = e.id " +
                " LEFT JOIN CM_EMPLOYEE_DEPARTMENT d on d.id = e.department_id ";

       return jdbcTemplate.query(sql, new EmployeeWithPersonalDataRowMapper());
    }

    private class EmployeeWithPersonalDataRowMapper implements RowMapper<EmployeeWithPersonalData> {

        @Override
        public EmployeeWithPersonalData mapRow(ResultSet rs, int rowNum) throws SQLException {
            return null; //TODO IMPL
        }
    }
}
