package com.ttmdaniel.core.requestprocessing;

import java.time.Instant;
import java.util.UUID;

public class IEvent {

    private final Instant when = Instant.now() ;
    private final UUID eventId = UUID.randomUUID() ;

    public Instant getWhen() {
        return when;
    }

    public UUID getEventId() {
        return eventId;
    }
}
