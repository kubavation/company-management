package com.durys.jakub.companymanagement.request.personal_request.controller;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import com.durys.jakub.companymanagement.request.personal_request.service.PersonalRequestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personal-requests")
@RequiredArgsConstructor
public class PersonalRequestTypeController {

    private final PersonalRequestTypeService personalRequestTypeService;

    @GetMapping
    public List<PersonalRequestType> findAll() {
        return personalRequestTypeService.findAll();
    }
}
