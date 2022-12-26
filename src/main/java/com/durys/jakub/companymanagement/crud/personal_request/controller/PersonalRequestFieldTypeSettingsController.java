//package com.durys.jakub.companymanagement.request.personal_request.controller;
//
//import com.durys.jakub.companymanagement.request.personal_request.converter.dict.PersonalRequestFieldTypeSettingsMapper;
//import com.durys.jakub.companymanagement.request.personal_request.model.dto.dict.PersonalRequestFieldTypeSettingsDTO;
//import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestFieldTypeSettingsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/personal-requests-field-settings")
//@RequiredArgsConstructor
//public class PersonalRequestFieldTypeSettingsController {
//
//    private final PersonalRequestFieldTypeSettingsService personalRequestFieldTypeSettingsService;
//    private final PersonalRequestFieldTypeSettingsMapper personalRequestFieldTypeSettingsMapper;
//
//    @GetMapping("/request-field-type/{fieldTypeId}")
//    public List<PersonalRequestFieldTypeSettingsDTO> findAllByRequestTypeId(@PathVariable Long fieldTypeId) {
//        return personalRequestFieldTypeSettingsMapper
//                .toDTO(personalRequestFieldTypeSettingsService.findAllByPersonalRequestTypeId(fieldTypeId));
//    }
//}
