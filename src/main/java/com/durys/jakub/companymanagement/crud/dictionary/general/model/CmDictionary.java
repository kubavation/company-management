package com.durys.jakub.companymanagement.crud.dictionary.general.model;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class CmDictionary {

    @Column(name = "DICTIONARY_ID")
    private Long dictionaryId;

    @Column(name = "DATE_FROM")
    private LocalDateTime dateFrom;

    @Column(name = "DATE_TO")
    private LocalDateTime dateTo;

    @Convert(converter = StatusConverter.class)
    private Status status;
}
