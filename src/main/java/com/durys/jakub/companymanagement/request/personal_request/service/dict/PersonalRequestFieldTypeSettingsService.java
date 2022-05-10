package com.durys.jakub.companymanagement.request.personal_request.service.dict;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestFieldTypeSettings;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestFieldTypeSettingsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalRequestFieldTypeSettingsService {

    private final PersonalRequestFieldTypeSettingsRepository personalRequestFieldTypeSettingsRepository;

    public List<PersonalRequestFieldTypeSettings> findAllByPersonalRequestTypeId(Long fieldTypeId) {
        return personalRequestFieldTypeSettingsRepository.findAllByFieldTypeId(fieldTypeId);
    }

}
