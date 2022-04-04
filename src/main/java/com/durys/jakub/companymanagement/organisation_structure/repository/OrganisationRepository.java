package com.durys.jakub.companymanagement.organisation_structure.repository;

import com.durys.jakub.companymanagement.organisation_structure.model.entity.OrganisationStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<OrganisationStructure, Long>  {

    List<OrganisationStructure> findAllByLevel(Long level);

    List<OrganisationStructure> findAllByParentId(Long parentId);
}
