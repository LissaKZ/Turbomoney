package com.omilia.samp.actions;

import com.omilia.diamant.dialog.components.fields.ApiField;

import javax.xml.soap.SOAPException;
import java.util.Map;

public interface Action {
    void process() throws SOAPException;

    void setInput(Map<String, ApiField> var1);

    Map<String, ApiField> getOutput();

    void setOutput(Map<String, ApiField> var1);
}
