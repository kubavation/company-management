package com.durys.jakub.companymanagement.organisation_structure.service;

import com.durys.jakub.companymanagement.organisation_structure.model.entity.OrganisationStructure;
import com.durys.jakub.companymanagement.organisation_structure.repository.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final OrganisationRepository organisationRepository;

    public List<OrganisationStructure> findAllByLevel(Long level) {
        return organisationRepository.findAllByLevel(level);
    }

    public List<OrganisationStructure> findAllByParentId(Long parentId) {
        return organisationRepository.findAllByParentId(parentId);
    }

    public List<OrganisationStructure> findAll() {
       return organisationRepository.findAll();
    }

}
