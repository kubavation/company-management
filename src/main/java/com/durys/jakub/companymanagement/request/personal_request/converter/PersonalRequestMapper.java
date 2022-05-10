package com.durys.jakub.companymanagement.request.personal_request.converter;

import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonalRequestFieldMapper.class})
public interface PersonalRequestMapper {

    PersonalRequestMapper INSTANCE = Mappers.getMapper( PersonalRequestMapper.class );


    @Mappings({
        @Mapping(source = "employee.id", target = "employeeId"),
        @Mapping(source = "requestType.id", target = "requestTypeId")
    })
    PersonalRequestDTO toDTO(PersonalRequest entity);

    List<PersonalRequestDTO> toDTO(List<PersonalRequest> entities);
}
