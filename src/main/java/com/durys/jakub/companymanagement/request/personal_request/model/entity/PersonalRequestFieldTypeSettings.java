package com.durys.jakub.companymanagement.request.personal_request.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD_TYPE_SETTINGS")
public class PersonalRequestFieldTypeSettings {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FIELD_TYPE_ID")
    private PersonalRequestFieldType fieldType;

    @Column(name = "REFRESH_FIELD_NAME")
    private String refreshFieldName;

}
