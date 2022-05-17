package com.durys.jakub.companymanagement.request.personal_request.service.general;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalRequestService {

    private final PersonalRequestRepository personalRequestRepository;

    public PersonalRequest findById(Long id) {
        return personalRequestRepository.findById(id)
                .orElseThrow(EntityNotFoundException.of(PersonalRequest.class, id));
    }

    public List<PersonalRequest> findByEmployeeId(Long employeeId) {
        return personalRequestRepository.findAllByEmployeeId(employeeId);
    }

    public PersonalRequest create(PersonalRequest personalRequest) {
        return personalRequestRepository.save(personalRequest);
    }

    public void delete(Long id) {
        Optional.of(findById(id)).ifPresent(personalRequestRepository::delete);
    }

}
