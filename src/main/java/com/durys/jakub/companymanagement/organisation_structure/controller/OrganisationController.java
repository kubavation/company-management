package com.durys.jakub.companymanagement.organisation_structure.controller;

import com.durys.jakub.companymanagement.organisation_structure.converter.OrganisationStructureMapper;
import com.durys.jakub.companymanagement.organisation_structure.model.dto.OrganisationDTO;
import com.durys.jakub.companymanagement.organisation_structure.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organisations")
@RequiredArgsConstructor
public class OrganisationController {

    private final OrganisationService organisationService;

    private final OrganisationStructureMapper organisationMapper;
    
    @GetMapping("/level/{level}")
    public List<OrganisationDTO> getOrganisationStructureByLevel(Long level) {
        return organisationMapper.toDTO(
                organisationService.findAllByLevel(level));
    }
}
