package com.durys.jakub.companymanagement.request.leave_request.model.dto;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class LeaveRequestFilterDTO {
    private Long employeeId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private List<LeaveRequestType> requestTypes;
}
