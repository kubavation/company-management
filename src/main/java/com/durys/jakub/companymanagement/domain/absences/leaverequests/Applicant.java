package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class Applicant {
    private final ApplicantId applicantId;

    private List<LeavePrivileges> leavePrivileges;

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public Applicant(Long applicantId) {
        this.applicantId = new ApplicantId(applicantId);
    }

    public LeaveRequestAggregate submit(LeaveRequestType requestType, LeaveRequestPeriod period) {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(requestType, this, period);

        //todo validate

        return leaveRequestAggregate;
    }

}
