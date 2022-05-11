package com.durys.jakub.companymanagement.request.personal_request.converter.general;

import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
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

//    @Mappings({
//        @Mapping(target = "fields", ignore = true),
//        @Mapping(target = "employee", ignore = true)
//    })
    PersonalRequest toEntity(PersonalRequestDTO dto);
}
