package com.durys.jakub.companymanagement.infrastructure.shared;

import com.durys.jakub.companymanagement.commons.IdentityProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class IdentityProviderConfiguration {


    @Bean
    public IdentityProvider identityProvider() {
        return new UUIDIdentityProvider();
    }

}
