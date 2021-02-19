package com.quadsquad.core.ddd;

import com.quadsquad.core.exception.AbstractValidationException;

public interface AbstractRequestValidator<T extends AbstractRequest> {
    void validate(T request) throws AbstractValidationException;
}
