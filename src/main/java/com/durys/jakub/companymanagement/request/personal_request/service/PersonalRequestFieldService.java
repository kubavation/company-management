package com.durys.jakub.companymanagement.request.personal_request.service;

import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestFieldRepository;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalRequestFieldService {

    private final PersonalRequestFieldRepository personalRequestFieldRepository;



}
