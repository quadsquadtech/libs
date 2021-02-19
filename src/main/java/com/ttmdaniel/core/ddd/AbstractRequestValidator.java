package com.ttmdaniel.core.ddd;

import com.ttmdaniel.core.exception.AbstractValidationException;

public interface AbstractRequestValidator<T extends AbstractRequest> {
    void validate(T request) throws AbstractValidationException;
}
