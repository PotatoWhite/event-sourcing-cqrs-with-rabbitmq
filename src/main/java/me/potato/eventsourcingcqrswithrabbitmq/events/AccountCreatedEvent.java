package me.potato.eventsourcingcqrswithrabbitmq.events;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountCreatedEvent extends BaseEvent<String> {
    private final BigDecimal accountBalance;
    private final String currency;

    public AccountCreatedEvent(String id, BigDecimal accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
