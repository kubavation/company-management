package com.durys.jakub.companymanagement.shared.entity;

import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Builder
@Getter
@Setter
public class BaseEntity {

    @Convert(converter = StatusConverter.class)
    private Status status;
}
