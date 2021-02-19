package com.quadsquad.core.ddd;

import com.quadsquad.core.generators.RandomIdGenerator;

public class AbstractTrackable extends AbstractInstantAction {

    private String trackableId ;

    public AbstractTrackable() {
        trackableId = RandomIdGenerator.generate();
    }

    void setTrackableId(String trackableId) {
        this.trackableId = trackableId;
    }


    public String getTrackableId() {
        return trackableId ;
    }
}
