package com.omilia.samp.handlers;



public interface Handler {
    boolean initialize();


    StringBuilder getParameterLog(String var1);

    void logResponseStatus(String var1, String var2, String var3);

    String getEndpoint();

    void activatePrintRqRsXml(Object var1);

    boolean isResponseValid(Object var1);
}
