package com.durys.jakub.companymanagement.organisation_structure.controller;

import com.durys.jakub.companymanagement.organisation_structure.converter.OrganisationStructureMapper;
import com.durys.jakub.companymanagement.organisation_structure.model.dto.OrganisationDTO;
import com.durys.jakub.companymanagement.organisation_structure.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OrganisationController {

    private final OrganisationService organisationService;

    private final OrganisationStructureMapper organisationMapper;
    
    @GetMapping("/level/{level}")
    public List<OrganisationDTO> getOrganisationStructureByLevel(@PathVariable Long level) {
        return organisationMapper.toDTO(
                organisationService.findAllByLevel(level));
    }

    @GetMapping("/parent/{parentId}")
    public List<OrganisationDTO> getOrganisationStructureByParentId(@PathVariable Long parentId) {
        return organisationMapper.toDTO(
                organisationService.findAllByParentId(parentId));
    }
}
