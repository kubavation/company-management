package com.durys.jakub.companymanagement.infrastructure.shared.events;


import com.durys.jakub.companymanagement.commons.events.publisher.DomainEventPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class EventsConfiguration {

    @Bean
    DomainEventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringEventPublisher(applicationEventPublisher);
    }

}
