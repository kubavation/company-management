package com.durys.jakub.companymanagement.request.personal_request.model.entity.general;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonalRequest implements CmEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = StatusConverter.class)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private PersonalRequestType employee;

    @ManyToOne
    @JoinColumn(name = "REQUEST_TYPE_ID", referencedColumnName = "ID")
    private PersonalRequestType requestType;

    @OneToMany(mappedBy = "personalRequest", cascade = CascadeType.PERSIST)
    private List<PersonalRequestField> fields;

}
