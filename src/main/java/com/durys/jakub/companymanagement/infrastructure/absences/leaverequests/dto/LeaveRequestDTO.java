package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LeaveRequestDTO {
    private LeaveRequestType requestType;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
