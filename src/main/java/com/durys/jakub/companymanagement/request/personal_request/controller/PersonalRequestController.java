package com.durys.jakub.companymanagement.request.personal_request.controller;

import com.durys.jakub.companymanagement.request.personal_request.facade.PersonalRequestFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal-request")
@RequiredArgsConstructor
public class PersonalRequestController {

    private final PersonalRequestFacade personalRequestFacade;
}
