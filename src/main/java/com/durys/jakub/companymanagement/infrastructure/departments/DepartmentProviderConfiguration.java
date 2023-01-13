package com.durys.jakub.companymanagement.infrastructure.departments;

import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DepartmentProviderConfiguration {


    @Bean
    WebClient organizationStructureClient() {
        return WebClient.builder().build();
    }

    @Bean
    DepartmentProvider restDepartmentProvider(@Qualifier("organizationStructureClient") WebClient webClient) {
        return new RestDepartmentProvider(webClient);
    }
}
