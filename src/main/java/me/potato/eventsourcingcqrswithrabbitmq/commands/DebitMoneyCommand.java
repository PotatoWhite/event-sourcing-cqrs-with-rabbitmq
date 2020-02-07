package me.potato.eventsourcingcqrswithrabbitmq.commands;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DebitMoneyCommand extends BaseCommand{
    private final BigDecimal debitAmount;

    private final String currency;

    public DebitMoneyCommand(Object id, BigDecimal debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
