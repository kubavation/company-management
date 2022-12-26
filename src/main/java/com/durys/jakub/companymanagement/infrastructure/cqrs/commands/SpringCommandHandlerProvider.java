package com.durys.jakub.companymanagement.infrastructure.cqrs.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandlerProvider;

import java.util.HashMap;
import java.util.Map;

public class SpringCommandHandlerProvider implements CommandHandlerProvider {


    private final Map<String, Class<?>> handlers = new HashMap<>();

    @Override
    public <T extends Command> CommandHandler<T> getCommandHandler(T command) {
        return null;
    }
}
