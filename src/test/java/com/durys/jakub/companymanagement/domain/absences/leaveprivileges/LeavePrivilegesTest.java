//package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;
//
//import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
//import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.RequestedDaysExceedLeavePrivilegesException;
//import com.durys.jakub.companymanagement.domain.absences.leaverequests.ApplicantId;
//import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
//import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LeavePrivilegesTest {
//
//    @Test
//    void checkCompatibility_shouldNotThrowAnyException() {
//
//        UUID employeeId = UUID.randomUUID();
//
//        LocalDate from = LocalDate.of(2022, 1 ,1);
//        LocalDate to = LocalDate.of(2022,12, 31);
//
//
//        LeavePrivilege leavePrivileges = new LeavePrivilege(LeaveRequestType.AL, new EmployeeId(employeeId),
//                new LeavePrivilegesPeriod(from, to),
//                new GrantedPrivileges(26, 180)
//        );
//
//        LeaveRequest leaveRequest = new DailyLeaveRequest(LeaveRequestType.AL,
//                LeaveRequestDailyPeriod.of(from.plusDays(10), from.plusDays(20)), new Applicant(new ApplicantId(employeeId)));
//
//        assertDoesNotThrow(() -> leavePrivileges.checkCompatibility(leaveRequest));
//    }
//
//    @Test
//    void checkCompatibility_shouldThrowRequestedDaysExceedLeavePrivilegesException() {
//
//        UUID employeeId = UUID.randomUUID();
//
//        LocalDate from = LocalDate.of(2022, 1 ,1);
//        LocalDate to = LocalDate.of(2022,12, 31);
//
//        LeavePrivilege leavePrivileges = new LeavePrivilege(LeaveRequestType.AL, new EmployeeId(employeeId),
//                new LeavePrivilegesPeriod(from, to),
//                new GrantedPrivileges(1, 10)
//        );
//
//        LeaveRequest leaveRequest = new DailyLeaveRequest(LeaveRequestType.AL,
//                LeaveRequestDailyPeriod.of(from.plusDays(10), from.plusDays(20)),
//                new Applicant(new ApplicantId(employeeId)));
//
//        assertThrows(RequestedDaysExceedLeavePrivilegesException.class, () -> leavePrivileges.checkCompatibility(leaveRequest));
//    }
//
//
//    @Test
//    void checkCompatibility_shouldThrowInvalidParameterException_invalidEmployeeId() {
//
//        UUID privilegesEmployeeId = UUID.randomUUID();
//        UUID applicantId = UUID.randomUUID();
//
//        LocalDate from = LocalDate.of(2022, 1 ,1);
//        LocalDate to = LocalDate.of(2022,12, 31);
//
//        LeavePrivilege leavePrivileges = new LeavePrivilege(LeaveRequestType.AL, new EmployeeId(privilegesEmployeeId),
//                new LeavePrivilegesPeriod(from, to),
//                new GrantedPrivileges(26, 180)
//        );
//
//        LeaveRequest leaveRequest = new DailyLeaveRequest(LeaveRequestType.AL,
//                LeaveRequestDailyPeriod.of(from.plusDays(10), from.plusDays(20)),
//                new Applicant(new ApplicantId(applicantId)));
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> leavePrivileges.checkCompatibility(leaveRequest));
//
//        assertEquals("Invalid employeeId param", exception.getMessage());
//    }
//
//    @Test
//    void checkCompatibility_shouldThrowInvalidParameterException_invalidRequestType() {
//
//        UUID employeeId = UUID.randomUUID();
//
//        LocalDate from = LocalDate.of(2022, 1 ,1);
//        LocalDate to = LocalDate.of(2022,12, 31);
//
//        LeavePrivilege leavePrivileges = new LeavePrivilege(LeaveRequestType.AL, new EmployeeId(employeeId),
//                new LeavePrivilegesPeriod(from, to),
//                new GrantedPrivileges(26, 180)
//        );
//
//        LeaveRequest leaveRequest = new DailyLeaveRequest(LeaveRequestType.CL,
//                LeaveRequestDailyPeriod.of(from.plusDays(10), from.plusDays(20)),
//                new Applicant(new ApplicantId(employeeId)));
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> leavePrivileges.checkCompatibility(leaveRequest));
//
//        assertEquals("Invalid requestType param", exception.getMessage());
//    }
//}