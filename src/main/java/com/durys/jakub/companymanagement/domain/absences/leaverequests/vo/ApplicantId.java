package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@AllArgsConstructor
public class ApplicantId extends EmployeeId {
    public ApplicantId(UUID id) {
        super(id);
    }
}
