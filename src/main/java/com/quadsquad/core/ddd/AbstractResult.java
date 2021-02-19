package com.quadsquad.core.ddd;

public class AbstractResult<I extends AbstractRequest> extends AbstractTrackable {

    private final I request;

    public AbstractResult(I request) {

        this.request = request;

        if (request != null) {
            setTrackableId(request.getTrackableId());
        }
    }

    public I getRequest() {
        return request;
    }
}
