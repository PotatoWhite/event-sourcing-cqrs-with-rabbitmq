package me.potato.eventsourcingcqrswithrabbitmq.aggregates;

import lombok.extern.slf4j.Slf4j;
import me.potato.eventsourcingcqrswithrabbitmq.commands.CreateAccountCommand;
import me.potato.eventsourcingcqrswithrabbitmq.commands.CreditMoneyCommand;
import me.potato.eventsourcingcqrswithrabbitmq.events.AccountActivatedEvent;
import me.potato.eventsourcingcqrswithrabbitmq.events.AccountCreatedEvent;
import me.potato.eventsourcingcqrswithrabbitmq.events.MoneyCreditedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Slf4j
@Aggregate
public class Account {

    @AggregateIdentifier
    private String id;
    private BigDecimal accountBalance;
    private String currency;
    private String status;


    @CommandHandler
    public Account(CreateAccountCommand createAccountCommand){
        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getAccountBalance(),
                createAccountCommand.getCurrency()
        ));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreateEvent){
        this.id = accountCreateEvent.getId();
        this.accountBalance = accountCreateEvent.getAccountBalance();
        this.currency = accountCreateEvent.getCurrency();
        this.status = String.valueOf(Status.CREATED);
    }

    @EventSourcingHandler
    protected void AccountActivateEvent(AccountActivatedEvent accountActivatedEvent){
        this.status = accountActivatedEvent.getStatus();
    }


    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand){
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.getId(), creditMoneyCommand.getCreditAmount(), creditMoneyCommand.getCurrency()));
    }

}
