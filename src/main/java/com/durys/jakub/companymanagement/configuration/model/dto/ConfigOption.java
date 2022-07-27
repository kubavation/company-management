package com.durys.jakub.companymanagement.configuration.model.dto;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigOption {
   private String value;
   private ConfigurationGroup configurationGroup;
   private String configurationType;
   private String description;

   public static ConfigOption of(CmConfigurationType<?> configType,
                                 ConfigurationGroup configGroup,
                                 String value) {
      return new ConfigOption(value, configGroup, configType.name(), configType.desc());
   }
}
