package com.durys.jakub.companymanagement.organisation_structure.service;

import com.durys.jakub.companymanagement.organisation_structure.repository.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final OrganisationRepository organisationRepository;

}
