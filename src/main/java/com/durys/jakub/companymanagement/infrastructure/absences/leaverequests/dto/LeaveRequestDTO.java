package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeaveRequestDTO {
    private Long employeeId;
    private String requestType;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
