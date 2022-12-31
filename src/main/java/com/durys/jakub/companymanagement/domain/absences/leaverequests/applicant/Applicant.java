package com.durys.jakub.companymanagement.domain.absences.leaverequests.applicant;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.acceptant.Acceptant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

@AggregateRoot
public class Applicant implements Employable {
    private final ApplicantId applicantId;

    //todo list of leavePrivileges

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public void submitLeaveRequest(LeaveRequest leaveRequest) {

//        LeavePrivilege privilege = getLeavePrivilege(leaveRequest.getRequestType(), leaveRequest.getPeriod().getTo().toLocalDate());
//        privilege.checkCompatibility(leaveRequest);
    }

    void cancel(LeaveRequest leaveRequest) {
        leaveRequest.markAsCancelled();
    }

    void sendToAcceptant(LeaveRequest leaveRequest, Acceptant acceptant) {
        leaveRequest.sendToAcceptant(acceptant);
    }

    void delete(LeaveRequest leaveRequest) {
        leaveRequest.markAsDeleted();
    }


    @Override
    public EmployeeId id() {
        return applicantId;
    }

}
