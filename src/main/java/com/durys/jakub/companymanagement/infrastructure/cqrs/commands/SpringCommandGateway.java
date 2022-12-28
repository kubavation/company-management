package com.durys.jakub.companymanagement.infrastructure.cqrs.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandlerProvider;

public class SpringCommandGateway implements CommandGateway {

    private final CommandHandlerProvider commandHandlerProvider;

    public SpringCommandGateway(CommandHandlerProvider commandHandlerProvider) {
        this.commandHandlerProvider = commandHandlerProvider;
    }

    @Override
    public <T extends Command> void dispatch(T command) {
        commandHandlerProvider.getCommandHandlerFor(command).handle(command);
    }
}
