package com.durys.jakub.companymanagement.infrastructure.employees.output;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "CM_EMPLOYEE")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    private Long id;

    @OneToOne(mappedBy = "employee_id")
    private EmployeePersonalDataEntity personalData;

    @Convert(converter = StatusConverter.class)
    private CmStatus cmStatus = CmStatus.ACTIVE;
}
