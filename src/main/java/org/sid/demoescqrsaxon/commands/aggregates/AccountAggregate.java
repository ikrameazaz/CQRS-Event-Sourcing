package org.sid.demoescqrsaxon.commands.aggregates;


import org.axonframework.spring.stereotype.Aggregate;
import org.sid.demoescqrsaxon.commands.enums.AccountStatus;

@Aggregate
public class AccountAggregate {
    public String accountID;
    public double balance;
    public AccountStatus status;


    public AccountAggregate() {
    }

}
