package com.quadsquad.core.requestprocessing;

import com.quadsquad.core.ILogger;

public class IConfiguration {

    private ILogger logger;
    private IValidator validator ;

    public IConfiguration() {

        logger = new ILogger() ;
        validator = new IValidator() ;
    }


    public ILogger getLogger() {
        return logger;
    }

    public IValidator getValidator() {
        return new IValidator() ;
    }
}
