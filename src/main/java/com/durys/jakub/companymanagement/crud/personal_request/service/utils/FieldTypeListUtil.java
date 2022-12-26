package com.durys.jakub.companymanagement.crud.personal_request.service.utils;

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
public class FieldTypeListUtil {

    private final JdbcTemplate jdbcTemplate;

    public List<KeyValue> generateListValues(String query) {

        try {
            return jdbcTemplate.query(query, new KeyValueMapper());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return new ArrayList<>();
    }
}
