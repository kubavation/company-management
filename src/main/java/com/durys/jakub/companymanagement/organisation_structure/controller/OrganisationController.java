package com.durys.jakub.companymanagement.organisation_structure.controller;

import com.durys.jakub.companymanagement.organisation_structure.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organisations")
@RequiredArgsConstructor
public class OrganisationController {

    private final OrganisationService organisationService;
    
//    @GetMapping
//    public List<>
}
