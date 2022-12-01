package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;


public class AcceptantId extends EmployeeId {
    public AcceptantId(UUID id) {
        super(id);
    }
}
