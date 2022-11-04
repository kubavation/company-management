package com.durys.jakub.companymanagement.request.leave_request.model.dto;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CreateLeaveRequest {
    private Long employeeId;
    private LeaveRequestType type;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private Long standInEmployeeId;
}
