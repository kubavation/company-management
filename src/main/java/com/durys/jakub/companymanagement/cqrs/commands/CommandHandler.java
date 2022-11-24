package com.durys.jakub.companymanagement.cqrs.commands;

public interface CommandHandler<T, R> {

    R handle(T t);
}
