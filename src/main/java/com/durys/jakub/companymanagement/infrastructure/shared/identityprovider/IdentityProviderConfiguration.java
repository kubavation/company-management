package com.durys.jakub.companymanagement.infrastructure.shared.identityprovider;

import com.durys.jakub.companymanagement.commons.IdentityProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdentityProviderConfiguration {


    @Bean
    public IdentityProvider identityProvider() {
        return new UUIDIdentityProvider();
    }

}
