package com.omilia.samp.utils.logging;

public interface Logging {
    void log(String var1, LogParameter... var2);

    void logInfo(String var1, LogParameter... var2);

    void logWarning(String var1, LogParameter... var2);

    void logError(String var1, LogParameter... var2);
}
