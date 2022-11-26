package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
enum LeaveRequestType {

    AL("Annual leave", "AL"),
    CL("Childcare leave", "CL");

    private final String name;
    private final String shortcut;
}
