package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeavePrivileges;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class JpaLeavePrivilegesRepository implements LeavePrivilegesRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<LeavePrivileges> load(EmployeeId employeeId) {
        return null;
    }

    @Override
    public LeavePrivileges load(EmployeeId employeeId, LeaveRequestType requestType, LocalDateTime from, LocalDateTime to) {
        return null;
    }
}
