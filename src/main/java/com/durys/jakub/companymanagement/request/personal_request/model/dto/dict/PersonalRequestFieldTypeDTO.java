package com.durys.jakub.companymanagement.request.personal_request.model.dto.dict;

import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import com.durys.jakub.companymanagement.shared.model.KeyValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldTypeDTO {
    private Long id;
    private String name;
    private String label;
    private FieldType type;
    private Integer lp;
    private List<KeyValue> list;
}
