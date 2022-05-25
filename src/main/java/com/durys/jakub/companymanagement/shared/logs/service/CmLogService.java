package com.durys.jakub.companymanagement.shared.logs.service;

import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import com.durys.jakub.companymanagement.shared.logs.model.CmLog;
import com.durys.jakub.companymanagement.shared.logs.repository.CmLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CmLogService {

    private final CmLogRepository cmLogRepository;

    private final ObjectWriter jsonWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    public <T extends CmEntity<? extends Long>> void log(T obj) {
        cmLogRepository.save(of(obj));
    }

    public <T extends CmEntity<? extends Long>> CmLog of(T obj) {
        return CmLog.builder()
                .className(getClassName(obj))
                .tableName(getTableName(obj))
                .operator("TODOOPERATOR")
                .timestamp(LocalDateTime.now())
                .primaryKey(obj.getId())
                .object(toJson(obj))
                .build();
    }

    private String getClassName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    private String getTableName(Object obj) {
        Table tableAnnotation = obj.getClass().getAnnotation(Table.class);
        if(tableAnnotation != null) {
            return tableAnnotation.name();
        }
        return "";
    }

    private String toJson(Object obj) {
        try {
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private void calculateChanges(Object object, Long pk) {
        cmLogRepository.findLastObjectById(pk);
    }
}
