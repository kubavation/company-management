package com.durys.jakub.companymanagement.request.personal_request.model.dto;

import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldTypeDTO {
    private Long id;
    private String name;
    private String label;
    private FieldType type;
    private Integer lp;
}
