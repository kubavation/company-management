package com.durys.jakub.companymanagement.infrastructure.cqrs.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandlerProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


public class SpringCommandHandlerProvider implements CommandHandlerProvider {

    private final ConfigurableListableBeanFactory configurableListableBeanFactory;

    private final Map<Class<?>, String> handlers = new HashMap<>();

    public SpringCommandHandlerProvider(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        this.configurableListableBeanFactory = configurableListableBeanFactory;
        prepareHandlers();
    }

    @Override
    public <T extends Command> CommandHandler<T> getCommandHandler(T command) {
        return null;
    }


    private void prepareHandlers() {
        Map<String, CommandHandler> handlerBeans = configurableListableBeanFactory.getBeansOfType(CommandHandler.class);
        handlerBeans.entrySet()
                .stream()
                .forEach(entry -> {
                    Class<?> commandType = handlerCommandType(entry.getValue().getClass());
                    handlers.put(commandType, entry.getKey());
                });
    }


    private Class<?> handlerCommandType(Class<? extends CommandHandler> handlerClass) {

        Type[] handlerInterfaces = handlerClass.getGenericInterfaces();

        for (Type type: handlerInterfaces) {
            if (type instanceof CommandHandler<?>) {
                return ((ParameterizedType) type).getActualTypeArguments()[0].getClass();
            }
        }

        return null;
    }

}
