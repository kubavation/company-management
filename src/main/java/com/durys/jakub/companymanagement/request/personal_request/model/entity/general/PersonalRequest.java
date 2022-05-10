package com.durys.jakub.companymanagement.request.personal_request.model.entity.general;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CM_PERSONAL_REQUEST")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequest {

    @Id
    private Long id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "REQUEST_TYPE_ID", referencedColumnName = "ID")
    private PersonalRequestType requestType;

    @OneToMany(mappedBy = "personalRequest")
    private List<PersonalRequestField> fields;

}
