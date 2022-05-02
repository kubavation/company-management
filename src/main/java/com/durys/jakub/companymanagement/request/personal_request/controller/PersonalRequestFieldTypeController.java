package com.durys.jakub.companymanagement.request.personal_request.controller;

import com.durys.jakub.companymanagement.request.personal_request.converter.PersonalRequestFieldTypeMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.PersonalRequestFieldTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import com.durys.jakub.companymanagement.request.personal_request.service.PersonalRequestFieldTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.PersonalRequestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personal-requests-fields")
@RequiredArgsConstructor
public class PersonalRequestFieldTypeController {

    private final PersonalRequestFieldTypeService personalRequestFieldTypeService;
    private final PersonalRequestFieldTypeMapper personalRequestFieldTypeMapper;

    @GetMapping("/request-type/{typeId}")
    public List<PersonalRequestFieldTypeDTO> findAllByRequestTypeId(@PathVariable Long typeId) {
        return personalRequestFieldTypeMapper
                .toDTO(personalRequestFieldTypeService.findAllByPersonalRequestTypeId(typeId));
    }
}
