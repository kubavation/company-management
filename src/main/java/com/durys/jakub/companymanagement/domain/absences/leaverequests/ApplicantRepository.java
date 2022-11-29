package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;

public interface ApplicantRepository {

    ApplicantId load(ApplicantId id);

}
