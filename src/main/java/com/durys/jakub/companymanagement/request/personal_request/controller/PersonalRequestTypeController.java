package com.durys.jakub.companymanagement.request.personal_request.controller;

import com.durys.jakub.companymanagement.request.personal_request.converter.dict.PersonalRequestTypeMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequestTypeRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.dict.PersonalRequestTypeDTO;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal-requests")
@RequiredArgsConstructor
public class PersonalRequestTypeController {

    private final PersonalRequestTypeService personalRequestTypeService;
    private final PersonalRequestTypeMapper personalRequestTypeMapper;

    @GetMapping
    public List<PersonalRequestTypeDTO> findAll() {
        return personalRequestTypeMapper.toDTO(personalRequestTypeService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreatePersonalRequestTypeRequest request) {
        PersonalRequestTypeDTO result =
                personalRequestTypeMapper.toDTO(personalRequestTypeService.save(request));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<?> delete(@PathVariable Long typeId) {
        personalRequestTypeService.delete(typeId);
        return ResponseEntity.ok().build();
    }


}
