package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.RequestedDaysExceedLeavePrivilegesException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LeavePrivilegesTest {

    @Test
    void checkCompatibility_shouldNotThrowAnyException() {

        UUID employeeId = UUID.randomUUID();

        LocalDate from = LocalDate.of(2022, 1 ,1);
        LocalDate to = LocalDate.of(2022,12, 31);

        LeavePrivileges leavePrivileges = new LeavePrivileges(LeaveRequestType.AL, new EmployeeId(employeeId),
                new LeavePrivilegesPeriod(from, to),
                new GrantedPrivileges(26, 180)
        );

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(LeaveRequestType.AL,
                new Applicant(new ApplicantId(employeeId)),
                new LeaveRequestPeriod(from.atStartOfDay().plusDays(10), from.atStartOfDay().plusDays(20)));

        assertDoesNotThrow(() -> leavePrivileges.checkCompatibility(leaveRequestAggregate));
    }
    
    @Test
    void checkCompatibility_shouldThrowRequestedDaysExceedLeavePrivilegesException() {

        UUID employeeId = UUID.randomUUID();

        LocalDate from = LocalDate.of(2022, 1 ,1);
        LocalDate to = LocalDate.of(2022,12, 31);

        LeavePrivileges leavePrivileges = new LeavePrivileges(LeaveRequestType.AL, new EmployeeId(employeeId),
                new LeavePrivilegesPeriod(from, to),
                new GrantedPrivileges(1, 10)
        );

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(LeaveRequestType.AL,
                new Applicant(new ApplicantId(employeeId)),
                new LeaveRequestPeriod(from.atStartOfDay().plusDays(10), from.atStartOfDay().plusDays(20)));

        assertThrows(RequestedDaysExceedLeavePrivilegesException.class, () -> leavePrivileges.checkCompatibility(leaveRequestAggregate));
    }
    

    @Test
    void checkCompatibility_shouldThrowInvalidParameterException_invalidEmployeeId() {

        UUID privilegesEmployeeId = UUID.randomUUID();
        UUID applicantId = UUID.randomUUID();

        LocalDate from = LocalDate.of(2022, 1 ,1);
        LocalDate to = LocalDate.of(2022,12, 31);

        LeavePrivileges leavePrivileges = new LeavePrivileges(LeaveRequestType.AL, new EmployeeId(privilegesEmployeeId),
                new LeavePrivilegesPeriod(from, to),
                new GrantedPrivileges(26, 180)
        );

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(LeaveRequestType.AL,
                new Applicant(new ApplicantId(applicantId)),
                new LeaveRequestPeriod(from.atStartOfDay().plusDays(10), from.atStartOfDay().plusDays(20)));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> leavePrivileges.checkCompatibility(leaveRequestAggregate));

        assertEquals("Invalid employeeId param", exception.getMessage());
    }
}