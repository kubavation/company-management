package com.durys.jakub.companymanagement.dictionary.configuration.repository;

import com.durys.jakub.companymanagement.dictionary.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.dictionary.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.dictionary.configuration.model.enums.ConfigurationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigurationValueRepository extends JpaRepository<ConfigurationValue, Long> {

    Optional<ConfigurationValue> findByConfigurationType(ConfigurationType type);

    List<ConfigurationValue> findAllByConfigurationGroup(ConfigurationGroup group);
}
