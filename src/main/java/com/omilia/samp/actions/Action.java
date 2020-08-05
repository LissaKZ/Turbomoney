package com.omilia.samp.actions;

import com.omilia.diamant.dialog.components.fields.ApiField;

import java.util.Map;

public interface Action {
    void process();

    void setInput(Map<String, ApiField> var1);

    Map<String, ApiField> getOutput();

    void setOutput(Map<String, ApiField> var1);
}
