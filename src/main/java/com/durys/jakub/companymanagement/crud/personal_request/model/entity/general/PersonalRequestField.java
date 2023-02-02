package com.durys.jakub.companymanagement.crud.personal_request.model.entity.general;

import com.durys.jakub.companymanagement.crud.personal_request.model.entity.dict.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_FIELD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonalRequestField implements CmEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Convert(converter = StatusConverter.class)
    private CmStatus cmStatus;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_REQUEST_ID")
    private PersonalRequest personalRequest;

    @ManyToOne
    @JoinColumn(name = "REQUEST_FIELD_TYPE_ID", referencedColumnName = "ID")
    private PersonalRequestFieldType requestFieldType;
}
