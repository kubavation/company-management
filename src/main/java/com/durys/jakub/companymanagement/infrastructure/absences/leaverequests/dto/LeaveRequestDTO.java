package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("Leave request")
public class LeaveRequestDTO {
    @ApiModelProperty(value = "Type of request", example = "CL")
    private LeaveRequestType requestType;
    @ApiModelProperty(value = "Date from", example = "2022-01-01")
    private LocalDateTime from;
    @ApiModelProperty(value = "Date to", example = "2022-01-01")
    private LocalDateTime to;
}
