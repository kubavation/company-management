package com.durys.jakub.companymanagement.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//        http.cors();
//        return http.build();
//    }
//}