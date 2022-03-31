package com.durys.jakub.companymanagement.employee.model.entity;

import com.durys.jakub.companymanagement.organisation_structure.model.entity.OrganisationStructure;

import javax.persistence.*;

@Table(name = "CM_EMPLOYEE")
@Entity
public class Employee {

    @Id
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "structure_id")
    private OrganisationStructure organisationStructure;

}
