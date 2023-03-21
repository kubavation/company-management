package com.durys.jakub.companymanagement.readmodel.leaverequests;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
public class EmployeeLeaveRequest {
    private UUID id;
    private UUID acceptantId;
    private String acceptantName;
    private String type;
    private LocalDate from;
    private LocalDate to;
    private BigDecimal hours;
    private BigDecimal minutes;
}
