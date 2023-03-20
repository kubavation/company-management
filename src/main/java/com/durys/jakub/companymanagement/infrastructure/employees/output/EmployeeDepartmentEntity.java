package com.durys.jakub.companymanagement.infrastructure.employees.output;

import com.durys.jakub.companymanagement.infrastructure.shared.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "CM_EMPLOYEE_DEPARTMENT")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDepartmentEntity {

    @Id
    private Long id;

    @Column(name = "DEPARTMENT_ID")
    private String departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "DEPARTMENT_SHORTCUT")
    private String departmentShortcut;

    @Column(name = "DEPARTMENT_PATH")
    private String departmentPath;

    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employees;

    @Convert(converter = Status.class)
    @Column(name = "STATUS")
    private Status cmStatus = Status.ACTIVE;
}
