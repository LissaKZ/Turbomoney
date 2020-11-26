package com.omilia.samp.actions;

import com.omilia.diamant.dialog.components.fields.ApiField;
import com.omilia.diamant.dialog.components.fields.FieldsContainer;
import com.omilia.diamant.loggers.DialogLogger;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.util.HashMap;
import java.util.Map;


public class SendSMSAction implements Action{
    protected Map<String, ApiField> output;
    protected DialogLogger logger;

    private FieldsContainer fieldsContainer;
    String phone;
    String text;

    public SendSMSAction(Map<String, ApiField> input, DialogLogger logger, FieldsContainer fieldsContainer) {
        this.output = new HashMap();
        this.logger = logger;
        this.fieldsContainer = fieldsContainer;
        this.setInput(input);
    }

    @Override
    public void process() throws SOAPException {

        SOAPMessage response = Sms.callSoapWebService("https://isms.center/ru/soap/server",
                "https://isms.center/ru/soap/server/",phone,text);
    }

    @Override
    public void setInput(Map<java.lang.String, ApiField> var1) {
        this.phone=var1.get("ANI").getValue();
        this.text=var1.get("SMSmessage").getValue();
    }

    @Override
    public Map<java.lang.String, ApiField> getOutput() {
        return output;
    }

    @Override
    public void setOutput(Map<java.lang.String, ApiField> var1) {
        output=var1;
    }
}