package com.durys.jakub.companymanagement.organisation_structure.service;

import com.durys.jakub.companymanagement.organisation_structure.model.entity.OrganisationStructure;
import com.durys.jakub.companymanagement.organisation_structure.repository.OrganisationRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrganisationServiceTest {

    @Mock
    private OrganisationRepository organisationRepository;

    @InjectMocks
    private OrganisationService organisationService;

    @Test
    void findAllByLevel_shouldReturnListOfSize2() {
        List<OrganisationStructure> structures = List.of(
                OrganisationStructure.builder().id(1L).level(1L).build(),
                OrganisationStructure.builder().id(2L).level(2L).build(),
                OrganisationStructure.builder().id(3L).level(2L).build()
        );

        when(organisationRepository.findAllByLevel(2L)).thenReturn(
                    List.of(
                            OrganisationStructure.builder().id(2L).level(2L).build(),
                            OrganisationStructure.builder().id(3L).level(2L).build()
                    ));

        List<OrganisationStructure> actual = organisationService.findAllByLevel(2L);
        assertEquals(actual.size(), 2);
    }

    @Test
    void findAllByParentId_shouldReturnListOfSize1() {
        List<OrganisationStructure> structures = List.of(
                OrganisationStructure.builder().id(1L).parentId(null).build(),
                OrganisationStructure.builder().id(2L).parentId(1L).build(),
                OrganisationStructure.builder().id(3L).parentId(2L).build()
        );

        when(organisationRepository.findAllByParentId(1L)).thenReturn(
                List.of(
                        OrganisationStructure.builder().id(2L).parentId(1L).build()
                ));

        List<OrganisationStructure> actual = organisationService.findAllByParentId(1L);
        assertEquals(actual.size(), 1);
    }
}