package com.durys.jakub.companymanagement.infrastructure.shared.registry;

import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;

@RequiredArgsConstructor
public class SpringDomainServicesRegistry implements DomainServicesRegistry {

    private final ListableBeanFactory beanFactory;

    @Override
    public <T> T instanceOf(Class<T> clazz) {
        return beanFactory.getBean(clazz);
    }
}
