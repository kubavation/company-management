package com.durys.jakub.companymanagement.organisation_structure.model.entity;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "CM_ORGANISATION_STRUCTURE")
@Entity
public class OrganisationStructure {

    @Id
    private Long id;

    private String name;
    private Long level;

    @OneToMany(mappedBy = "organisationStructure")
    private Set<Employee> employees;
}
