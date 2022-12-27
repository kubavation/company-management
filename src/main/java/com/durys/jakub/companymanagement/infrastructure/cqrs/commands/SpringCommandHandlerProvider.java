package com.durys.jakub.companymanagement.infrastructure.cqrs.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandlerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SpringCommandHandlerProvider implements CommandHandlerProvider {

    private final ConfigurableListableBeanFactory configurableListableBeanFactory;

    private final Map<String, Class<?>> handlers = new HashMap<>();

    public SpringCommandHandlerProvider(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        this.configurableListableBeanFactory = configurableListableBeanFactory;
    }

    @Override
    public <T extends Command> CommandHandler<T> getCommandHandler(T command) {
        return null;
    }


    private void prepareHandlers() {
        //todo
    }
}
