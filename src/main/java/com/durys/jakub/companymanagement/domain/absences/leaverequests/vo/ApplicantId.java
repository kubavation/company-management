package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;


@Getter
public record ApplicantId(UUID id) implements Serializable {
}
