package com.durys.jakub.companymanagement.crud.menuconfig.model;

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
