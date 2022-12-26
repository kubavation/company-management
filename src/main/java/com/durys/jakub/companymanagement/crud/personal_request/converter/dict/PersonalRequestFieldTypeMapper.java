//package com.durys.jakub.companymanagement.request.personal_request.converter.dict;
//
//import com.durys.jakub.companymanagement.request.personal_request.model.dto.dict.PersonalRequestFieldTypeDTO;
//import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestFieldType;
//import com.durys.jakub.companymanagement.request.personal_request.service.utils.FieldTypeListUtil;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public abstract class PersonalRequestFieldTypeMapper {
//
//    @Autowired
//    protected FieldTypeListUtil fieldTypeListUtil;
//
//    @Mapping(target = "list", expression = "java(fieldTypeListUtil.generateListValues(entity.getListQuery()))")
//    public abstract PersonalRequestFieldTypeDTO toDTO(PersonalRequestFieldType entity);
//
//    public abstract List<PersonalRequestFieldTypeDTO> toDTO(List<PersonalRequestFieldType> entity);
//}
