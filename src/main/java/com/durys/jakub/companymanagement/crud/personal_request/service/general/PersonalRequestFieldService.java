package com.durys.jakub.companymanagement.crud.personal_request.service.general;

import com.durys.jakub.companymanagement.crud.personal_request.model.entity.general.PersonalRequestField;
import com.durys.jakub.companymanagement.crud.personal_request.repository.PersonalRequestFieldRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalRequestFieldService {

    private final PersonalRequestFieldRepository personalRequestFieldRepository;

    public PersonalRequestField findById(Long id) {
        return personalRequestFieldRepository.findById(id)
                .orElseThrow(EntityNotFoundException.of(PersonalRequestField.class, id));
    }

    public List<PersonalRequestField> findAllByRequestId(Long requestId) {
        return personalRequestFieldRepository.findAllByPersonalRequestId(requestId);
    }

}
