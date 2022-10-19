package com.durys.jakub.companymanagement.request.leave_request.model.dto;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LeaveRequestDTO {
    private Long id;
    private Long employeeId;
    private LeaveRequestType type;
    private LocalDate date;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private BigDecimal days;
    private BigDecimal hours;
    private Long standInEmployeeId;
}
