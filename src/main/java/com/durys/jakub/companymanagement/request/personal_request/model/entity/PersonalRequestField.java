package com.durys.jakub.companymanagement.request.personal_request.model.entity;

import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestField {

    @Id
    private Long id;

    private String value;
    private String status;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_REQUEST_ID")
    private PersonalRequest personalRequest;
}
