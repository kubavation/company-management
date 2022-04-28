package com.durys.jakub.companymanagement.dictionary.model.entity;

import com.durys.jakub.companymanagement.dictionary.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.dictionary.model.enums.ConfigurationType;
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
public class ConfigurationValue {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONFIGURATION_GROUP")
    private ConfigurationGroup configurationGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONFIGURATION_TYPE")
    private ConfigurationType configurationType;

    private String value;
    private String status;
}
