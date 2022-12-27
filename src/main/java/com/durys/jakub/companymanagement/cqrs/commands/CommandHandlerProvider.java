package com.durys.jakub.companymanagement.cqrs.commands;

public interface CommandHandlerProvider {
    <T extends Command> CommandHandler<T> getCommandHandler(Class<T> commandType);
}
