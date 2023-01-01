package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

@AggregateRoot
public class Applicant implements Employable {
    private final ApplicantId applicantId;

    //todo list of leavePrivileges


    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }


    public LeaveRequest submit(LeaveRequest.WorkInProgress leaveRequest) {
        return leaveRequest.instance().markAsSubmitted()
    }

    public void cancel(LeaveRequest leaveRequest) {
        leaveRequest.markAsCancelled();
    }

    public void sendToAcceptant(LeaveRequest leaveRequest, Acceptant acceptant) {
        leaveRequest.setAcceptant(acceptant);
    }

    void delete(LeaveRequest leaveRequest) {
        leaveRequest.markAsDeleted();
    }


    @Override
    public EmployeeId id() {
        return applicantId;
    }

}
