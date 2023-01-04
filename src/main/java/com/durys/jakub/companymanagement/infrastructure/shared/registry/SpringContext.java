package com.durys.jakub.companymanagement.infrastructure.shared.registry;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        if (context == null) {
            synchronized (this) {
                SpringContext.context = ctx;
            }
        }
    }

    static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
