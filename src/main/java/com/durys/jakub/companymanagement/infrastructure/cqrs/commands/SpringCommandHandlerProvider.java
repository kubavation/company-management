package com.durys.jakub.companymanagement.infrastructure.cqrs.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandlerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class SpringCommandHandlerProvider implements CommandHandlerProvider {

    private final ConfigurableListableBeanFactory configurableListableBeanFactory;

    private final Map<Class<? extends Command>, String> handlers = new HashMap<>();

    public SpringCommandHandlerProvider(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        this.configurableListableBeanFactory = configurableListableBeanFactory;
        prepareHandlers();
    }

    @Override
    public <T extends Command> CommandHandler<T> getCommandHandlerFor(T command) {
        log.info("searching for commandHandler | command = {}", command.getClass().getSimpleName());
        return commandHandlerOf((Class<T>)command.getClass());
    }


    private void prepareHandlers() {
        log.info("start - prepare command handlers");

        configurableListableBeanFactory.getBeansOfType(CommandHandler.class)
                .entrySet()
                .stream()
                .forEach(entry -> handlers.put(handlerCommandType(entry.getValue().getClass()), entry.getKey()));
    }


    private Class<? extends Command> handlerCommandType(Class<? extends CommandHandler> handlerClass) {

        Type[] handlerInterfaces = handlerClass.getGenericInterfaces();

        for (Type type: handlerInterfaces) {
            if (type instanceof ParameterizedType parameterizedType) {
                return (Class<? extends Command>) parameterizedType.getActualTypeArguments()[0];
            }
        }

        return null;
    }

    private <T extends Command> CommandHandler<T> commandHandlerOf(Class<T> commandType) {

        log.info(commandType.getSimpleName());

        return configurableListableBeanFactory.getBean(handlers.get(commandType), CommandHandler.class);
    }

}
