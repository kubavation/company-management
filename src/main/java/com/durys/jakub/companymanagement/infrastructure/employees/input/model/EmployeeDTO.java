package com.durys.jakub.companymanagement.infrastructure.employees.input.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("Employee")
public class EmployeeDTO {

    @ApiModelProperty(value = "ID of department", example = "31aab9b6-a321-11ed-a8fc-0242ac120002")
    private String departmentId;
    @ApiModelProperty(value = "Employee personal data")
    private EmployeePersonalDataDTO personalData;
    @ApiModelProperty(value = "List of employee graduations")
    private List<GraduationDTO> graduations;
}
