package com.durys.jakub.companymanagement.infrastructure.employees.output;

import com.durys.jakub.companymanagement.infrastructure.shared.status.Status;
import com.durys.jakub.companymanagement.infrastructure.shared.status.StatusDBConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "CM_EMPLOYEE")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Convert(converter = StatusDBConverter.class)
    private Status status = Status.ACTIVE;
}
