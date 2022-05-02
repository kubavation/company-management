package com.durys.jakub.companymanagement.request.personal_request.model.entity;

import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldType {

    @Id
    private Long id;

    private String name;
    private String label;

    @Enumerated(EnumType.STRING)
    private FieldType type;

    private String status;
    private Integer lp;

    @Column(name = "LIST_QUERY")
    private String listQuery;

    @ManyToOne
    @JoinColumn(name = "REQUEST_TYPE_ID")
    private PersonalRequestType requestType;

    @OneToMany(mappedBy = "fieldType", fetch = FetchType.LAZY)
    private List<PersonalRequestFieldTypeSettings> settings;
}
