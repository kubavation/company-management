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
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CmLogService {

    private final CmLogRepository cmLogRepository;

    private final ObjectWriter jsonWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    public <T extends CmEntity<? extends Long>> void log(T obj) {

        CmLog log = of(obj);
        log = withChanges(log, obj.getClass());

        cmLogRepository.save(log);
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

    private String calculateChanges(CmLog log, Class<?> clazz) {
        String changes =
                cmLogRepository.findLastObjectByIdAndTableName(log.getPrimaryKey(), log.getTableName())
                        .map(e -> {
                            Field[] fields = clazz.getFields();
                            for (Field field : fields) {
                                System.out.println(field.getName());
                            }
                            return "test";
                        })
                        .orElse("brak");
        System.out.println(changes);
        return changes;
    }

    private CmLog withChanges(CmLog log, Class<?> clazz) {
        String changes = calculateChanges(log, clazz);
         log.setChanges(changes);
        return log;
    }
}
