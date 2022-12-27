package com.durys.jakub.companymanagement.infrastructure.cqrs;

import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandlerProvider;
import com.durys.jakub.companymanagement.infrastructure.cqrs.commands.SpringCommandGateway;
import com.durys.jakub.companymanagement.infrastructure.cqrs.commands.SpringCommandHandlerProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CqrsConfiguration {

    @Bean
    CommandHandlerProvider commandHandlerProvider(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        return new SpringCommandHandlerProvider(configurableListableBeanFactory);
    }

    @Bean
    CommandGateway commandGateway(CommandHandlerProvider commandHandlerProvider) {
        return new SpringCommandGateway(commandHandlerProvider);
    }
}
