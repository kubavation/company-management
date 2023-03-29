package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import lombok.Getter;

import java.util.UUID;


@Getter
public class ApplicantId extends EmployeeId {
    public ApplicantId(UUID id) {
        super(id);
    }
}
