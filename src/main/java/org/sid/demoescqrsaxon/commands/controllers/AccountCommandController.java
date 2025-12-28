package org.sid.demoescqrsaxon.commands.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.sid.demoescqrsaxon.commands.commands.AddAccountCommand;
import org.sid.demoescqrsaxon.commands.dto.AddNewAcountRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/commands/accounts")
public class AccountCommandController {

    public CommandGateway commandGateway;

    public AccountCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
@PostMapping("/add")
    public String AddNewAccount(@RequestBody AddNewAcountRequestDto request) {
        return commandGateway.send(new AddAccountCommand(
                UUID.randomUUID().toString(),
                request.initialBalance(),
                request.currency()
        ));
    }
}
