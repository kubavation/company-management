package com.durys.jakub.companymanagement.request.personal_request.controller;

import com.durys.jakub.companymanagement.request.personal_request.facade.PersonalRequestFacade;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal-request")
@RequiredArgsConstructor
public class PersonalRequestController {

    private final PersonalRequestFacade personalRequestFacade;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonalRequestDTO personalRequestDTO) {
        personalRequestFacade.create(personalRequestDTO);
        return null;
    }
}
