package com.durys.jakub.companymanagement.infrastructure.employees.output;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "CM_EMPLOYEE_PERSONAL_DATA")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePersonalDataEntity {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private String gender;

    @Convert(converter = StatusConverter.class)
    @Column(name = "CM_STATUS")
    private CmStatus cmStatus;
}