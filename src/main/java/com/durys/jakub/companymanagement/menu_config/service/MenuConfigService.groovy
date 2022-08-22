package com.durys.jakub.companymanagement.menu_config.service

import com.durys.jakub.companymanagement.menu_config.model.MenuConfig
import groovy.json.JsonSlurper
import org.springframework.stereotype.Service

@Service
class MenuConfigService {


    List<MenuConfig> getMenuConfig() {
        def json = new JsonSlurper()
                .parse(getClass().getClassLoader().getResource("menu-config.json"))
        json.menu.findAll {it.enabled}
    }
}
