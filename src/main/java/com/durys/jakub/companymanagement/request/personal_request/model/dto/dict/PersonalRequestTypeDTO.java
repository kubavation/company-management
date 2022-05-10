package com.durys.jakub.companymanagement.request.personal_request.model.dto.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
