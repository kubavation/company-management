package com.durys.jakub.companymanagement.menu_config.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class MenuConfig {

    private String url;
    private String name;
    private Set<MenuConfig> children;
    private String icon;
}
