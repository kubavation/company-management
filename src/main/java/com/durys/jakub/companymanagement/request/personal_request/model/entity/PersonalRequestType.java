package com.durys.jakub.companymanagement.request.personal_request.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestType {

    @Id
    private Long id;

    private String name;
    private String status;

    @OneToMany(mappedBy = "requestType")
    List<PersonalRequestFieldType> requestFieldTypes;

}
