package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivileges;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.LeavePrivilegesNotGrantedException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HashMapLeavePrivilegesRepository implements LeavePrivilegesRepository {

    private static final HashMap<EmployeeId, List<LeavePrivileges>> DB = new HashMap<>();

    @Override
    public List<LeavePrivileges> load(EmployeeId employeeId) {
        return DB.get(employeeId);
    }

    @Override
    public <T extends EmployeeId> LeavePrivileges load(T employeeId, LeaveRequestType type, LocalDate date) {
        return load(employeeId)
                .stream()
                .filter(l -> l.getLeaveRequestType().equals(type))
                .filter(l -> l.getPeriod().isInPeriod(date))
                .findFirst()
                .orElseThrow(LeavePrivilegesNotGrantedException::new);
    }

    @Override
    public void save(LeavePrivileges leavePrivileges) {
        List<LeavePrivileges> privileges = DB.get(leavePrivileges.getEmployeeId());
        privileges.add(leavePrivileges);
        DB.put(leavePrivileges.getEmployeeId(), privileges);
    }
}
