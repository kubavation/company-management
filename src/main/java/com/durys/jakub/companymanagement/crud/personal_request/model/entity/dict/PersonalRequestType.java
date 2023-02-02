package com.durys.jakub.companymanagement.crud.personal_request.model.entity.dict;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PersonalRequestType implements CmEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Convert(converter = StatusConverter.class)
    private CmStatus cmStatus;

    @OneToMany(mappedBy = "requestType", fetch = FetchType.EAGER)
    private List<PersonalRequestFieldType> requestFieldTypes;

}
