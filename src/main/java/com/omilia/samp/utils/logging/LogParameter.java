package com.omilia.samp.utils.logging;

public class LogParameter {
    private String valueToLog;
    private boolean isSensitive;

    public LogParameter(Object valueToLog, boolean isSensitive) {
        this.valueToLog = String.valueOf(valueToLog);
        this.isSensitive = isSensitive;
    }

    public static LogParameter[] noParams() {
        return new LogParameter[0];
    }

    public void setValueToLog(String valueToLog) {
        this.valueToLog = valueToLog;
    }

    public void setSensitive(boolean isSensitive) {
        this.isSensitive = isSensitive;
    }

    public String getValueToLog() {
        return this.valueToLog;
    }

    public boolean isSensitive() {
        return this.isSensitive;
    }
}
