package com.durys.jakub.companymanagement.configuration.model.dto;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.util.ConfigurationGroup;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
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

   public static ConfigOption of(String value, String configurationType) {
      return ConfigOption.builder()
              .value(value)
              .configurationType(configurationType)
              .build();
   }
}
