package com.durys.jakub.companymanagement.infrastructure.cqrs.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;

public class SpringCommandGateway implements CommandGateway {

    @Override
    public <T extends Command> void dispatch(T command) {
        
    }
}
