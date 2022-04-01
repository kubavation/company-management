package com.durys.jakub.companymanagement.organisation_structure.repository;

import com.durys.jakub.companymanagement.organisation_structure.model.entity.OrganisationStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<OrganisationStructure, Long>  {
}
