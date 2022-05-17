package com.durys.jakub.companymanagement.request.personal_request.controller;

import com.durys.jakub.companymanagement.request.personal_request.facade.PersonalRequestFacade;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal-request")
@RequiredArgsConstructor
public class PersonalRequestController {

    private final PersonalRequestFacade personalRequestFacade;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreatePersonalRequest createPersonalRequest) {
        personalRequestFacade.create(createPersonalRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<?> delete(@PathVariable Long requestId) {
        personalRequestFacade.delete(requestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
