package com.durys.jakub.companymanagement.commons.domain;

import com.durys.jakub.companymanagement.infrastructure.shared.registry.SpringDomainServicesRegistry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainServicesRegistry {
    public static <T> T instanceOf(Class<T> clazz) {
        return SpringDomainServicesRegistry.instanceOf(clazz);
    }
}
