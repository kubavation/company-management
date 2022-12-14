package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivileges;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.LeavePrivilegesNotGrantedException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Applicant implements Employable {
    private final ApplicantId applicantId;

    private List<LeavePrivileges> leavePrivileges;

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public Applicant(ApplicantId applicantId, List<LeavePrivileges> leavePrivileges) {
        this.applicantId = applicantId;
        this.leavePrivileges = leavePrivileges;
    }

    public LeaveRequestAggregate submitLeaveRequest(LeaveRequest leaveRequest, LeavePrivileges leavePrivileges) {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(requestType, this, period);
        leavePrivileges.checkCompatibility(leaveRequestAggregate);
        return leaveRequestAggregate;
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
}
