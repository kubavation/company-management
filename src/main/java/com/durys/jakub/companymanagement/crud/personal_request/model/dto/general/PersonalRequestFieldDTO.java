package com.durys.jakub.companymanagement.crud.personal_request.model.dto.general;

import com.durys.jakub.companymanagement.crud.personal_request.model.enums.FieldType;
import com.durys.jakub.companymanagement.shared.model.KeyValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldDTO {
    private Long id;
    private String value;

    private Long fieldTypeId;
    private String name;
    private String label;
    private FieldType type;
    private List<KeyValue> list;
}