package me.potato.eventsourcingcqrswithrabbitmq.events;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MoneyDebitedEvent extends BaseEvent<String> {
    private final BigDecimal debitAmount;
    private final String currency;

    public MoneyDebitedEvent(String id, BigDecimal debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
