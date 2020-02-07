package me.potato.eventsourcingcqrswithrabbitmq.events;

import lombok.Getter;
import me.potato.eventsourcingcqrswithrabbitmq.commands.BaseCommand;

@Getter
public class AccountHeldEvent extends BaseCommand<String> {
    private final String status;

    public AccountHeldEvent(String id, String status) {
        super(id);
        this.status = status;
    }
}
