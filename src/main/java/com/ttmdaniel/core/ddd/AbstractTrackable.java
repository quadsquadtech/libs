package com.ttmdaniel.core.ddd;

import com.ttmdaniel.core.generators.RandomIdGenerator;

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
