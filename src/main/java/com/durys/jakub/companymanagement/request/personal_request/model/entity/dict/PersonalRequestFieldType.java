package com.durys.jakub.companymanagement.request.personal_request.model.entity.dict;

import com.durys.jakub.companymanagement.request.personal_request.model.enums.FieldType;
import com.durys.jakub.companymanagement.shared.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonalRequestFieldType {

    @Id
    private Long id;

    private String name;
    private String label;

    @Enumerated(EnumType.STRING)
    private FieldType type;

    @Enumerated(value = EnumType.STRING)
    private Status status;
    private Integer lp;

    @Column(name = "LIST_QUERY")
    private String listQuery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUEST_TYPE_ID")
    private PersonalRequestType requestType;

    @OneToMany(mappedBy = "fieldType", fetch = FetchType.LAZY)
    private List<PersonalRequestFieldTypeSettings> settings;
}
