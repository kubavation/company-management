package com.durys.jakub.companymanagement.menu_config.service

import groovy.json.JsonSlurper
import org.springframework.stereotype.Service

@Service
class MenuConfigService {


    String getMenuConfig() {
        File file = new File("src/main/resources/menu-config.json")
        def json = new JsonSlurper().parse(file)
        json.menu.findAll {it.enabled}
    }
}
