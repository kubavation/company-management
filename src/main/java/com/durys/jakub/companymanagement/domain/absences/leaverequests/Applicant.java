package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilege;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.LeavePrivilegesNotGrantedException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
public class Applicant implements Employable {
    private final ApplicantId applicantId;
    private List<LeavePrivilege> leavePrivileges;

    private List<LeaveRequest> leaveRequests;

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public Applicant(ApplicantId applicantId, List<LeavePrivilege> leavePrivileges, List<LeaveRequest> leaveRequests) {
        this.applicantId = applicantId;
        this.leavePrivileges = leavePrivileges;
        this.leaveRequests = leaveRequests;
    }

    public void submitLeaveRequest(LeaveRequest leaveRequest) {

        LeavePrivilege privilege = getLeavePrivilege(leaveRequest.getRequestType(), leaveRequest.getPeriod().getTo().toLocalDate());
        privilege.checkCompatibility(leaveRequest);
    }

    public void cancel(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsCancelled();
    }

    public void sendToAcceptant(LeaveRequestAggregate leaveRequest, Acceptant acceptant) {
        leaveRequest.sendToAcceptant(acceptant);
    }

    public void delete(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsDeleted();
    }


    @Override
    public EmployeeId getId() {
        return applicantId;
    }

    LeavePrivilege getLeavePrivilege(LeaveRequestType type, LocalDate date) {
        return leavePrivileges.stream()
                .filter(lp -> lp.getPeriod().isInPeriod(date))
                .filter(lp -> lp.getLeaveRequestType().equals(type))
                .findFirst()
                .orElseThrow(LeavePrivilegesNotGrantedException::new);
    }


}
