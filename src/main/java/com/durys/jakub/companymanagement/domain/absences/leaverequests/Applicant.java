package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.LeavePrivilegesNotGrantedException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class Applicant implements Employable {
    private final ApplicantId applicantId;

    private List<LeavePrivileges> leavePrivileges;

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public Applicant(UUID applicantId) {
        this.applicantId = new ApplicantId(applicantId);
    }

    public LeaveRequestAggregate submit(LeaveRequestType requestType, LeaveRequestPeriod period) {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(requestType, this, period);

        LeavePrivileges privileges = loadPrivileges(requestType, period);
        privileges.checkCompatibility(leaveRequestAggregate);

        return leaveRequestAggregate;
    }

    public void delete(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsDeleted();
    }

    public void cancel(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsCancelled();
    }

    public void send(LeaveRequestAggregate leaveRequest, Acceptant acceptant) {
        leaveRequest.sendToAcceptant(acceptant);
    }


    public LeavePrivileges loadPrivileges(LeaveRequestType requestType, LeaveRequestPeriod period) {
        return leavePrivileges.stream()
                .filter(p -> p.inPrivileges(period, requestType))
                .findFirst()
                .orElseThrow(LeavePrivilegesNotGrantedException::new);
    }

    @Override
    public EmployeeId getId() {
        return applicantId;
    }
}
