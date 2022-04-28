package com.durys.jakub.companymanagement.dictionary.model.enums;

public enum ConfigurationType {

     TEST(ConfigurationGroup.DEFAULT);

     private final ConfigurationGroup group;

     ConfigurationType(ConfigurationGroup group) {
        this.group = group;
     }
}
