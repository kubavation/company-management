package com.durys.jakub.companymanagement.request.personal_request;

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

    @GetMapping("/request-type/{typeId}")
    public List<PersonalRequestFieldType> findAllByRequestTypeId(@PathVariable Long typeId) {
        return personalRequestFieldTypeService.findAllByPersonalRequestTypeId(typeId);
    }
}
