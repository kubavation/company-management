package com.durys.jakub.companymanagement.crud.personal_request.model.dto.creational;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePersonalRequestField {
    private String value;
    private Long fieldTypeId;
}
