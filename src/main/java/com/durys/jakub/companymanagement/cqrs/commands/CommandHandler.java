package com.durys.jakub.companymanagement.cqrs.commands;

public interface CommandHandler<T extends Command> {

    void handle(T t);
}
