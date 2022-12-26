package com.durys.jakub.companymanagement.crud.personal_request.service.dict;

import com.durys.jakub.companymanagement.crud.personal_request.model.entity.dict.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.crud.personal_request.repository.PersonalRequestFieldTypeRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalRequestFieldTypeService {

    private final PersonalRequestFieldTypeRepository personalRequestFieldTypeRepository;

    public List<PersonalRequestFieldType> findAllByPersonalRequestTypeId(Long requestTypeId) {
        return personalRequestFieldTypeRepository.findAllByRequestTypeId(requestTypeId);
    }

    public PersonalRequestFieldType findById(Long id) {
        return personalRequestFieldTypeRepository.findById(id)
                .orElseThrow(EntityNotFoundException.of(PersonalRequestFieldType.class, id));
    }


    private void refreshFieldListValues() {

    }


}
