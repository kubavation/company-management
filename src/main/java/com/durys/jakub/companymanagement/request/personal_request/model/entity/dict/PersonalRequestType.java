package com.durys.jakub.companymanagement.request.personal_request.model.entity.dict;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalRequestType {

    @Id
    private Long id;

    private String name;
    private String desc;
    private String status;

    @OneToMany(mappedBy = "requestType", fetch = FetchType.EAGER)
    private List<PersonalRequestFieldType> requestFieldTypes;

}
