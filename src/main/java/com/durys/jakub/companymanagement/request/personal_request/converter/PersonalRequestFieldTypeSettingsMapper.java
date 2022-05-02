package com.durys.jakub.companymanagement.request.personal_request.converter;

import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldTypeSettingsDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldTypeSettings;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalRequestFieldTypeSettingsMapper {

    PersonalRequestFieldTypeSettingsMapper INSTANCE = Mappers.getMapper( PersonalRequestFieldTypeSettingsMapper.class );

    PersonalRequestFieldTypeSettingsDTO toDTO(PersonalRequestFieldTypeSettings entity);

    List<PersonalRequestFieldTypeSettingsDTO> toDTO(List<PersonalRequestFieldTypeSettings> entity);
}
