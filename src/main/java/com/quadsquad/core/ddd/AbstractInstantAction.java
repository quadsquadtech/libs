package com.quadsquad.core.ddd;

import java.time.Instant;
import java.util.Date;

public class AbstractInstantAction {

    private Instant actionInstant ;
    private Date actionDate ;

    public AbstractInstantAction() {
        actionInstant = Instant.now() ;
        actionDate = new Date() ;
    }

    public Instant getActionInstant() {
        return actionInstant ;
    }

    public Date getActionDate() {
        return actionDate ;
    }

    void setActionInstant(Instant actionInstant) {
        this.actionInstant = actionInstant;
    }

    void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
