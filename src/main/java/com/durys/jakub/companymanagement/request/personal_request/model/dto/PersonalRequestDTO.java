package com.durys.jakub.companymanagement.request.personal_request.model.dto;


import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonalRequestDTO {

    private Long id;
    private Long employeeId;
    private Long requestTypeId;
    private List<PersonalRequestFieldDTO> fields;
}
