package com.durys.jakub.companymanagement.request.personal_request.converter;

import com.durys.jakub.companymanagement.organisation_structure.converter.OrganisationStructureMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.service.utils.FieldTypeListUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PersonalRequestFieldTypeMapper {

    @Autowired
    protected FieldTypeListUtil fieldTypeListUtil;

    @Mapping(target = "list", expression = "java(fieldTypeListUtil.generateListValues(entity.getListQuery()))")
    public abstract PersonalRequestFieldTypeDTO toDTO(PersonalRequestFieldType entity);

    public abstract List<PersonalRequestFieldTypeDTO> toDTO(List<PersonalRequestFieldType> entity);
}
