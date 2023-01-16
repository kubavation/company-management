package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;


@AggregateRoot
public class Applicant implements Employable {
    private final ApplicantId applicantId;
    private final LeaveEntitlements leaveEntitlements;


    public Applicant(ApplicantId applicantId, LeaveEntitlements leaveEntitlements) {
        this.applicantId = applicantId;
        this.leaveEntitlements = leaveEntitlements;
    }


    public LeaveRequest submit(LeaveRequest.WorkInProgress leaveRequest) {
       return leaveRequest
                .withApplicant(applicantId)
                .submit();
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
