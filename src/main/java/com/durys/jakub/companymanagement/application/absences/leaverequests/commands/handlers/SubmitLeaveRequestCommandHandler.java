package com.durys.jakub.companymanagement.application.absences.leaverequests.commands.handlers;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SubmitLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;

@CommandHandling
public class SubmitLeaveRequestCommandHandler implements CommandHandler<SubmitLeaveRequestCommand> {

    @Override
    public void handle(SubmitLeaveRequestCommand submitLeaveRequestCommand) {
        //TODO
    }
}
