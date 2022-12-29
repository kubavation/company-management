package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.DomainEntity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.LeavePrivilegesNotGrantedException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@DomainEntity
@Getter
public class Applicant implements Employable {
    private final ApplicantId applicantId;

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public void submitLeaveRequest(LeaveRequest leaveRequest) {

//        LeavePrivilege privilege = getLeavePrivilege(leaveRequest.getRequestType(), leaveRequest.getPeriod().getTo().toLocalDate());
//        privilege.checkCompatibility(leaveRequest);
    }

    public void cancel(LeaveRequest leaveRequest) {
        leaveRequest.markAsCancelled();
    }

    public void sendToAcceptant(LeaveRequest leaveRequest, Acceptant acceptant) {
        leaveRequest.sendToAcceptant(acceptant);
    }

    public void delete(LeaveRequest leaveRequest) {
        leaveRequest.markAsDeleted();
    }


    @Override
    public EmployeeId getId() {
        return applicantId;
    }

}
