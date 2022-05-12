package com.durys.jakub.companymanagement.request.personal_request.service.dict;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestTypeRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalRequestTypeService {

    private final PersonalRequestTypeRepository personalRequestTypeRepository;

    public List<PersonalRequestType> findAll() {
        return personalRequestTypeRepository.findAll();
    }

    public PersonalRequestType findById(Long id) {
        return personalRequestTypeRepository.findById(id)
                .orElseThrow(EntityNotFoundException.of(PersonalRequestType.class, id));
    }
}
