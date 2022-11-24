package com.durys.jakub.companymanagement.cqrs.commands;

public interface CommandHandler<T extends Command, R> {

    R handle(T t);
}
