package com.durys.jakub.companymanagement.organisation_structure.model.entity;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;

import javax.persistence.*;
import java.util.Set;

@Table(name = "CM_ORGANISATION_STRUCTURE")
@Entity
public class OrganisationStructure {

    @Id
    private Long id;

    private String name;
    private Long level;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @OneToMany(mappedBy = "organisationStructure")
    private Set<Employee> employees;
}
