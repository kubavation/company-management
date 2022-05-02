package com.durys.jakub.companymanagement.request.personal_request.service;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldTypeSettings;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestFieldTypeRepository;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestFieldTypeSettingsRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import com.durys.jakub.companymanagement.shared.model.KeyValue;
import com.durys.jakub.companymanagement.shared.sqlmappers.KeyValueMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
