package com.durys.jakub.companymanagement.infrastructure.shared.registry;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SpringDomainServicesRegistry {

    public static <T> T instanceOf(Class<T> clazz) {
        return SpringContext.getBean(clazz);
    }
}
