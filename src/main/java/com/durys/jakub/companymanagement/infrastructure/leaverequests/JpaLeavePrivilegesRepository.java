package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivileges;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class JpaLeavePrivilegesRepository implements LeavePrivilegesRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<LeavePrivileges> load(EmployeeId employeeId) {
        return null;
    }

}
