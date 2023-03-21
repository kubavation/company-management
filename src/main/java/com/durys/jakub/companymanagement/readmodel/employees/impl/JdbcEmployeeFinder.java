package com.durys.jakub.companymanagement.readmodel.employees.impl;

import com.durys.jakub.companymanagement.readmodel.employees.EmployeeFinder;
import com.durys.jakub.companymanagement.readmodel.employees.EmployeeWithPersonalData;
import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteria;
import com.durys.jakub.companymanagement.readmodel.shared.SearchCriteriaBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class JdbcEmployeeFinder implements EmployeeFinder {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<EmployeeWithPersonalData> findEmployeesWithPersonalData(SearchCriteria criteria) {

        String sql = "SELECT e.id, pd.first_name, pd.last_name," +
                "pd.gender, pd.birthday_date," +
                "d.department_id, d.department_name," +
                "d.department_shortcut, d.department_path" +
                " FROM CM_EMPLOYEE e" +
                " INNER JOIN CM_EMPLOYEE_PERSONAL_DATA pd on pd.employee_id = e.id " +
                " LEFT JOIN CM_EMPLOYEE_DEPARTMENT d on d.id = e.department_id ";

       return jdbcTemplate.query(SearchCriteriaBuilderService.appendCriteria(sql, criteria), new EmployeeWithPersonalDataRowMapper());
    }

    private static class EmployeeWithPersonalDataRowMapper implements RowMapper<EmployeeWithPersonalData> {

        @Override
        public EmployeeWithPersonalData mapRow(ResultSet rs, int rowNum) throws SQLException {
            return EmployeeWithPersonalData.builder()
                    .employeeId(UUID.fromString(rs.getString("id")))
                    .firstName(rs.getString("first_name"))
                    .lastName(rs.getString("last_name"))
                    .gender(rs.getString("gender"))
                    .birthdayDate(rs.getDate("birthday_date").toLocalDate())
                    .departmentId(rs.getString("department_id"))
                    .departmentName(rs.getString("department_name"))
                    .departmentShortcut(rs.getString("department_shortcut"))
                    .departmentPath(rs.getString("department_path"))
                    .build();
        }
    }
}
