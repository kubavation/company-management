package com.durys.jakub.companymanagement.request.personal_request.converter.dict;

import com.durys.jakub.companymanagement.request.personal_request.model.dto.dict.PersonalRequestTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
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
