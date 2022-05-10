package com.durys.jakub.companymanagement.request.personal_request.facade;

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


    public PersonalRequest create(PersonalRequest personalRequest, List<PersonalRequestField> fields) {

        return null;
    }
}
