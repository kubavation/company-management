package com.durys.jakub.companymanagement.request.personal_request.model.entity.dict;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD_TYPE_SETTINGS")
@NoArgsConstructor
@Data
public class PersonalRequestFieldTypeSettings {

    @Id
    private Long id;

    @Convert(converter = StatusConverter.class)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "FIELD_TYPE_ID")
    private PersonalRequestFieldType fieldType;

    @Column(name = "REFRESH_FIELD_NAME")
    private String refreshFieldName;

    @Column(name = "PARAM_NAME")
    private String paramName;

}
