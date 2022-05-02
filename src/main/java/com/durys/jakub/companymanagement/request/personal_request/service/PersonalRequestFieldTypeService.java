package com.durys.jakub.companymanagement.request.personal_request.service;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestFieldTypeRepository;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalRequestFieldTypeService {

    private final PersonalRequestFieldTypeRepository personalRequestFieldTypeRepository;

    public List<PersonalRequestFieldType> findAllByPersonalRequestTypeId(Long requestTypeId) {
        return personalRequestFieldTypeRepository.findAllByRequestTypeId(requestTypeId);
    }

}
