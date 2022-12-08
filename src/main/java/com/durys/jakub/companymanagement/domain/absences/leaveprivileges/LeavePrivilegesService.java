package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

import java.time.LocalDate;

public interface LeavePrivilegesService {
    LeavePrivileges load(ApplicantId applicantId, LeaveRequestType requestType, LocalDate date);
}
