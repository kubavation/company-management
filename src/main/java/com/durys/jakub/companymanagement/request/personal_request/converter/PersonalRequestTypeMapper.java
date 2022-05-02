package com.durys.jakub.companymanagement.request.personal_request.converter;

import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonalRequestFieldTypeMapper.class})
public interface PersonalRequestTypeMapper {

    PersonalRequestTypeMapper INSTANCE = Mappers.getMapper( PersonalRequestTypeMapper.class );

    @Mapping(source = "entity.requestFieldTypes", target = "requestFieldTypes")
    PersonalRequestTypeDTO toDTO(PersonalRequestType entity);

    List<PersonalRequestTypeDTO> toDTO(List<PersonalRequestType> entity);
}
