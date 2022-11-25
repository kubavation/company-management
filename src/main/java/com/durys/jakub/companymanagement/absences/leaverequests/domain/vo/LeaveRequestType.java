package com.durys.jakub.companymanagement.absences.leaverequests.domain.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
enum LeaveRequestType {

    AL("Annual leave", "AL"),
    CL("Childcare leave", "CL");

    private final String name;
    private final String shortcut;
}
