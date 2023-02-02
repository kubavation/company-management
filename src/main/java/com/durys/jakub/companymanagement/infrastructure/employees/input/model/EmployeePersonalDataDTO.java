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
@ApiModel("Employee personal data")
public class EmployeePersonalDataDTO {

    @ApiModelProperty(value = "Employee first name", example = "John")
    private String firstName;
    @ApiModelProperty(value = "Employee last name", example = "Doe")
    private String lastName;
    @ApiModelProperty(value = "Employee gender", example = "MAN", allowableValues = "MAN, WOMAN")
    private String gender;
    @ApiModelProperty(value = "Employee birthday date", example = "1901-01-01")
    private LocalDate birthdayDate;
}
