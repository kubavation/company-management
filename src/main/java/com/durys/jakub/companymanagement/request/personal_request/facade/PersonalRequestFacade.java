package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestFieldService;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonalRequestFacade {

    private final PersonalRequestService personalRequestService;
    private final PersonalRequestFieldService personalRequestFieldService;
    private final PersonalRequestMapper personalRequestMapper;

    public PersonalRequest create(PersonalRequestDTO requestDTO) {
        System.out.println(requestDTO);
        PersonalRequest entity = personalRequestMapper.toEntity(requestDTO);
        System.out.println(entity);

        return null;
    }
}
