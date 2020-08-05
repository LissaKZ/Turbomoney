package com.omilia.samp.handlers;

import com.omilia.diamant.loggers.DialogLogger;

public abstract class AbstractHandler implements Handler{
    protected static final String OPENING_SERVICE = "Opening service...";
    protected DialogLogger logger;
    private String endpoint;

    public AbstractHandler(DialogLogger logger, String endpoint, String handlerName) {
        this.logger = logger;
        this.endpoint = endpoint;
    }

    public StringBuilder getParameterLog(String wsName) {
        return new StringBuilder("Calling " + wsName + " with parameters: ");
    }

    public boolean isResponseValid(Object content) {
        return content != null;
    }

    public void logResponseStatus(String statusCode, String statusSeverity, String statusDesc) {
    }

    public String getEndpoint() {
        return this.endpoint;
    }
}
