//package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges;
//
//import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilege;
//import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
//import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
//import lombok.AllArgsConstructor;
//
//import java.time.LocalDate;
//
//@AllArgsConstructor
//public class ApplicantLeavePrivilegesService implements LeavePrivilegesService {
//
//    private final LeavePrivilegesRepository leavePrivilegesRepository;
//
//    @Override
//    public LeavePrivilege load(ApplicantId applicantId, LeaveRequestType requestType, LocalDate date) {
//        return leavePrivilegesRepository.load(applicantId, requestType, date);
//    }
//}
