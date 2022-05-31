package com.durys.jakub.companymanagement.shared.logs.service;

import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import com.durys.jakub.companymanagement.shared.logs.model.CmLog;
import com.durys.jakub.companymanagement.shared.logs.repository.CmLogRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CmLogService {

    private final CmLogRepository cmLogRepository;

    private final ObjectWriter jsonWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private final ObjectReader jsonReader = new ObjectMapper().reader();

    private final static String CHANGES_PATTERN = "%s: %s->%s;";

    public <T extends CmEntity<? extends Long>> void log(T obj) {
        CmLog log = withChanges(of(obj), obj);
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

    private <T> T fromJson(String json, Class<T> clazz) throws Exception {
        try {
            return jsonReader.forType(clazz).readValue(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return clazz.getConstructor().newInstance();
        }
    }

    private <T> String calculateChanges(CmLog log, T obj) {
        return cmLogRepository.findLastObjectByIdAndTableName(log.getPrimaryKey(), log.getTableName())
                    .map(e -> {
                        try {
                            T lastObject = (T) fromJson(e.getObject(), obj.getClass());
                            return prepareChangeObject(obj, lastObject, lastObject.getClass());
                        } catch (Exception ex) {
                           return "";
                        }
                    })
                    .orElse("");
    }

    private CmLog withChanges(CmLog log, Object obj) {
        String changes = calculateChanges(log, obj);
        log.setChanges(changes);
        return log;
    }

    private <T> String prepareChangeObject(T oldObj, T newObj, Class<? extends T> clazz) throws Exception {

        StringBuilder sb = new StringBuilder();

       for(Field field: clazz.getDeclaredFields()) {
           field.setAccessible(true);
           Object oldValue = field.get(oldObj);
           Object newValue = field.get(newObj);

           if ((!Objects.equals(oldValue, newValue) || !Objects.equals(newValue, oldValue))
                && isFieldLoggable(field)) {
             sb.append(CHANGES_PATTERN.formatted(field.getName(), oldValue, newValue));
           }
       }

       return sb.toString();
    }

    private boolean isFieldLoggable(Field field) {
        return !(Collection.class.isAssignableFrom(field.getType())
            || field.getType().isAssignableFrom(CmEntity.class));
    }
}
