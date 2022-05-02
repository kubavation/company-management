package com.durys.jakub.companymanagement.request.personal_request.model.dto;

import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestTypeDTO {
    private Long id;
    private String name;
    private String desc;
    private List<PersonalRequestFieldTypeDTO> requestFieldTypes;
}
