package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LeaveRequestType {

    AL("Annual leave", "AL"),
    CL("Childcare leave", "CL");

    private final String name;
    private final String shortcut;
}
