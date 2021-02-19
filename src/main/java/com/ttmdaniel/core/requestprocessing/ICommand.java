package com.ttmdaniel.core.requestprocessing;

import java.time.Instant;
import java.util.UUID;

public class ICommand {

    private final Instant when = Instant.now() ;
    private final UUID commandId = UUID.randomUUID() ;

    public Instant getWhen() {
        return when;
    }

    public UUID getCommandId() {
        return commandId;
    }
}
