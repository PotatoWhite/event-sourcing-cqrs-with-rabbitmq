package me.potato.eventsourcingcqrswithrabbitmq.commands;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreditMoneyCommand extends BaseCommand<String> {
    private final BigDecimal creditAmount;
    private final String currency;

    public CreditMoneyCommand(String id, BigDecimal creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
