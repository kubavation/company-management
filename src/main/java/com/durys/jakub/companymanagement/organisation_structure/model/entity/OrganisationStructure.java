package com.durys.jakub.companymanagement.organisation_structure.model.entity;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.shared.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String shortcut;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "DATE_FROM")
    private LocalDateTime dateFrom;

    @Column(name = "DATE_TO")
    private LocalDateTime dateTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private OrganisationStructure parent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private Set<OrganisationStructure> children;

    @OneToMany(mappedBy = "organisationStructure")
    private Set<Employee> employees;
}
