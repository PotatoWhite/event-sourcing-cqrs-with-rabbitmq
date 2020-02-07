package me.potato.eventsourcingcqrswithrabbitmq.events;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MoneyCreditedEvent extends BaseEvent<String>{
    private final BigDecimal creditAmount;
    private final String currency;

    public MoneyCreditedEvent(String id, BigDecimal creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
