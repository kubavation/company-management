package com.durys.jakub.companymanagement.crud.personal_request.model.dto.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldTypeSettingsDTO {
    private Long id;
    private Long fieldTypeId;
    private String refreshFieldName;
    private String paramName;
}
