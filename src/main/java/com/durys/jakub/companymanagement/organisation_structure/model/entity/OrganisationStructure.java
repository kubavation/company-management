package com.durys.jakub.companymanagement.organisation_structure.model.entity;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "CM_ORGANISATION_STRUCTURE")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganisationStructure {

    @Id
    private Long id;

    private String name;
    private Long level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private OrganisationStructure parent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private Set<OrganisationStructure> children;

    @OneToMany(mappedBy = "organisationStructure")
    private Set<Employee> employees;
}