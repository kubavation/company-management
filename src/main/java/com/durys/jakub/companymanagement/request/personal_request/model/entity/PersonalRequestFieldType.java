package com.durys.jakub.companymanagement.request.personal_request.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldType {

    @Id
    private Long id;

    private String label;

    private String type; //todo enum type
    private String status;
    private Integer lp;

}
