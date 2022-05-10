package com.durys.jakub.companymanagement.request.personal_request.converter;

import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.service.utils.FieldTypeListUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PersonalRequestFieldMapper {

    @Autowired
    protected FieldTypeListUtil fieldTypeListUtil;

    @Mappings({
        @Mapping(source = "requestFieldType.id", target = "fieldTypeId"),
        @Mapping(source = "requestFieldType.name", target = "name"),
        @Mapping(source = "requestFieldType.type", target = "type"),
        @Mapping(source = "requestFieldType.label", target = "label"),
        @Mapping(target = "requestFieldType.list", expression = "java(fieldTypeListUtil.generateListValues(entity.getListQuery()))"),
    })
    public abstract PersonalRequestFieldDTO toDTO(PersonalRequestField entity);
}
