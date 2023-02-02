package com.durys.jakub.companymanagement.crud.configuration.model.entity;

import com.durys.jakub.companymanagement.crud.configuration.model.enums.group.ConfigurationGroupName;
import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CM_CONFIGURATION_VALUE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ConfigurationValue implements CmEntity<Long> {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONFIGURATION_GROUP")
    private ConfigurationGroupName configurationGroup;

    @Column(name = "CONFIGURATION_TYPE")
    private String configurationType;

    private String value;

    @Convert(converter = StatusConverter.class)
    private CmStatus cmStatus;
}
