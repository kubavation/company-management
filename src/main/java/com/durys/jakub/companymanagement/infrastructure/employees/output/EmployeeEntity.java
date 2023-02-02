package com.durys.jakub.companymanagement.infrastructure.employees.output;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import lombok.AllArgsConstructor;
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

    @Column(name = "DOMAIN_ID")
    private String domainId;

    @Column(name = "TENANT_ID")
    private String tenantId;

    @OneToOne(mappedBy = "employee")
    private EmployeePersonalDataEntity personalData;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private EmployeeDepartmentEntity department;

    @Convert(converter = StatusConverter.class)
    @Column(name = "CM_STATUS")
    private CmStatus cmStatus = CmStatus.ACTIVE;
}
