package com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaveprivileges.commands.GrantLeaveRequestPrivilegesCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import lombok.RequiredArgsConstructor;

@CommandHandling
public class GrantLeaveRequestPrivilegesCommandHandler implements CommandHandler<GrantLeaveRequestPrivilegesCommand> {

    @Override
    public void handle(GrantLeaveRequestPrivilegesCommand command) {

    }
}
