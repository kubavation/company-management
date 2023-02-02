package com.durys.jakub.companymanagement.infrastructure.employees.input.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("Employee graduation")
public class GraduationDTO {

    @ApiModelProperty(value = "Name of school", example = "First school")
    private String schoolName;
    @ApiModelProperty(value = "Date from", example = "2022-01-01")
    private LocalDate dateFrom;
    @ApiModelProperty(value = "Date to", example = "2022-01-01")
    private LocalDate dateTo;
    @ApiModelProperty(value = "Type of graduation", example = "PRIMARY",
            allowableValues = "PRIMARY, SECONDARY, HIGHER")
    private String type;
}