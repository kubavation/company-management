package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
public record LeaveRequestId(UUID value) {
}
