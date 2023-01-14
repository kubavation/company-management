package com.durys.jakub.companymanagement.infrastructure.departments;

import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DepartmentProviderConfiguration {

    @Bean
    @LoadBalanced
    WebClient.Builder organizationStructureClient() {
        return WebClient.builder()
                .baseUrl("http://ORGANIZATION-STRUCTURE-SERVICE/api/organization-structure");
    }

    @Bean
    DepartmentProvider restDepartmentProvider(@Qualifier("organizationStructureClient") WebClient.Builder webClient) {
        return new RestDepartmentProvider(webClient.build());
    }
}
