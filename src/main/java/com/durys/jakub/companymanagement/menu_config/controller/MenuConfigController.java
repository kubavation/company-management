package com.durys.jakub.companymanagement.menu_config.controller;

import com.durys.jakub.companymanagement.menu_config.model.MenuConfig;
import com.durys.jakub.companymanagement.menu_config.service.MenuConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-config")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MenuConfigController {

    private final MenuConfigService menuConfigService;


    @GetMapping
    public List<MenuConfig> getMenuConfig() {
        return menuConfigService.getMenuConfig();
    }
}
