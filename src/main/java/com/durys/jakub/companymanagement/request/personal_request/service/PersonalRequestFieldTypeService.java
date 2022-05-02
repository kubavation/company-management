package com.durys.jakub.companymanagement.request.personal_request.service;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestFieldTypeRepository;
import com.durys.jakub.companymanagement.request.personal_request.repository.PersonalRequestTypeRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import com.durys.jakub.companymanagement.shared.model.KeyValue;
import com.durys.jakub.companymanagement.shared.sqlmappers.KeyValueMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalRequestFieldTypeService {

    private final PersonalRequestFieldTypeRepository personalRequestFieldTypeRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<PersonalRequestFieldType> findAllByPersonalRequestTypeId(Long requestTypeId) {
        return personalRequestFieldTypeRepository.findAllByRequestTypeId(requestTypeId);
    }

    public PersonalRequestFieldType findById(Long id) {
        return personalRequestFieldTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PersonalRequestFieldType.class, id));
    }


    public List<KeyValue> generateListValues(Long fieldTypeId) {

        String listQuery = findById(fieldTypeId).getListQuery();

        try {
            return jdbcTemplate.query(listQuery, new KeyValueMapper());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return new ArrayList<>();
    }

}
