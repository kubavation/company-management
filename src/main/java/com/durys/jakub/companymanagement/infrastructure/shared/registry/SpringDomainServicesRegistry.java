package com.durys.jakub.companymanagement.infrastructure.shared.registry;

import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SpringDomainServicesRegistry implements DomainServicesRegistry {

    @Override
    public <T> T instanceOf(Class<T> clazz) {
        return SpringContext.getBean(clazz);
    }
}
