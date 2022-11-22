package com.durys.jakub.companymanagement.menuconfig.controller;

import com.durys.jakub.companymanagement.menuconfig.model.MenuConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-config")
@RequiredArgsConstructor
public class MenuConfigController {

    //private final MenuConfigService menuConfigService;
//    @GetMapping
//    public List<MenuConfig> getMenuConfig() {
//        return menuConfigService.getMenuConfig();
//    }
}
