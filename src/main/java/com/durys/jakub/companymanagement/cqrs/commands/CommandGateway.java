package com.durys.jakub.companymanagement.cqrs.commands;

public interface CommandGateway {
    <T extends Command> void dispatch(T command);
}
