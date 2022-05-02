package com.durys.jakub.companymanagement.request.personal_request.model.dto;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import com.durys.jakub.companymanagement.shared.model.KeyValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldTypeSettingsDTO {
    private Long id;
    private Long fieldTypeId;
    private String refreshFieldName;
    private String paramName;
}
