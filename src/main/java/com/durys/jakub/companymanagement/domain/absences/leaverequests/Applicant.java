package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilege;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.util.List;

@AggregateRoot
public class Applicant implements Employable {
    private final ApplicantId applicantId;

    private List<LeavePrivilege> leavePrivileges;


    public Applicant(ApplicantId applicantId,) {
        this.applicantId = applicantId;
    }


    public LeaveRequest submit(LeaveRequest.WorkInProgress leaveRequest) {
        leaveRequest.withApplicant(applicantId);
        return leaveRequest.submit();
    }

    public void cancel(LeaveRequest leaveRequest) {
        leaveRequest.markAsCancelled();
    }

    public void sendToAcceptant(LeaveRequest leaveRequest, Acceptant acceptant) {
        leaveRequest.setAcceptant(acceptant);
    }

    public void delete(LeaveRequest leaveRequest) {
        leaveRequest.markAsDeleted();
    }

    @Override
    public EmployeeId employeeId() {
        return applicantId;
    }

}
