package com.durys.jakub.companymanagement.request.personal_request.converter;

import com.durys.jakub.companymanagement.organisation_structure.converter.OrganisationStructureMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalRequestFieldTypeMapper {

    PersonalRequestFieldTypeMapper INSTANCE = Mappers.getMapper( PersonalRequestFieldTypeMapper.class );

    PersonalRequestFieldTypeDTO toDTO(PersonalRequestFieldType entity);

    List<PersonalRequestFieldTypeDTO> toDTO(List<PersonalRequestFieldType> entity);
}
