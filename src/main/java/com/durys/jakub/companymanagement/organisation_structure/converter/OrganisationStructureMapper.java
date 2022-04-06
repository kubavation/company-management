package com.durys.jakub.companymanagement.organisation_structure.converter;

import com.durys.jakub.companymanagement.organisation_structure.model.dto.OrganisationDTO;
import com.durys.jakub.companymanagement.organisation_structure.model.entity.OrganisationStructure;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganisationStructureMapper {

    OrganisationStructureMapper INSTANCE = Mappers.getMapper( OrganisationStructureMapper.class );

    OrganisationDTO toDTO(OrganisationStructure organisationStructure);

    List<OrganisationDTO> toDTO(List<OrganisationStructure> organisationStructures);
}
