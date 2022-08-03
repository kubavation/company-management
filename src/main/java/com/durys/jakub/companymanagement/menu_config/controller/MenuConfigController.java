package com.durys.jakub.companymanagement.menu_config.controller;

import com.durys.jakub.companymanagement.menu_config.service.MenuConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu-config")
@RequiredArgsConstructor
public class MenuConfigController {

    private final MenuConfigService menuConfigService;

    @GetMapping
    public String getMenuConfig() {
        return menuConfigService.getMenuConfig();
    }
}
