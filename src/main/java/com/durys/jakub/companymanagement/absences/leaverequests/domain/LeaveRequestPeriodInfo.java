package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.annotations.domain.ValueObject;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@ValueObject
class LeaveRequestPeriodInfo {

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    LeaveRequestPeriodInfo(LocalDateTime dateFrom, LocalDateTime dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
