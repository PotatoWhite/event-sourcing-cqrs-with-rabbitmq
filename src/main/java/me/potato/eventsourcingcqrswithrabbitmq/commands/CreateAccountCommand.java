package me.potato.eventsourcingcqrswithrabbitmq.commands;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateAccountCommand extends BaseCommand<String> {

    private final BigDecimal accountBalance;

    private final String currency;


    public CreateAccountCommand(String id, BigDecimal accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
