package com.durys.jakub.companymanagement.request.leave_request.model.dto;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//TODO
@Data
@NoArgsConstructor
public class LeaveRequestDTO {
    private Long id;
    private Long employeeId;
    private LeaveRequestType type;
    private BigDecimal days;
    private BigDecimal hours;
}
