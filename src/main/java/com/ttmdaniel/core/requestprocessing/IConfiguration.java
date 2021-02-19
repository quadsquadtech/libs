package com.ttmdaniel.core.requestprocessing;

import com.ttmdaniel.core.abstracts.ILogger;

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
