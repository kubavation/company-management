package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Applicant {
    private final ApplicantId applicantId;

    public Applicant(ApplicantId applicantId) {
        this.applicantId = applicantId;
    }

    public Applicant(Long applicantId) {
        this.applicantId = new ApplicantId(applicantId);
    }

}
