package com.omilia.samp.actions;

import com.baeldung.springsoap.client.gen.SMSM;
import com.baeldung.springsoap.client.gen.SendSMSServiceSendMessage;
import com.baeldung.springsoap.client.gen.SendSMSServiceSendMessageResponse;
import com.omilia.diamant.dialog.components.fields.ApiField;
import com.omilia.diamant.dialog.components.fields.FieldStatus;
import com.omilia.diamant.dialog.components.fields.FieldsContainer;
import com.omilia.diamant.loggers.DialogLogger;
import com.omilia.samp.handlers.SendSMSHandler;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

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
        this.fieldsContainer=fieldsContainer;
        this.setInput(input);
//    }
//    public static void main(String[] args){
//
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("com.baeldung.springsoap.client.gen");
//        Sms client=new Sms();
//        client.setDefaultUri("https://isms.center/ru/soap/server");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//
//        SendSMSServiceSendMessageResponse response = client.GetResponse(login,password);
//
    }


    @Override
    public void process() {
        SendSMSHandler sendSMSHandler=new SendSMSHandler(logger,phone,text);
        if (sendSMSHandler.initialize()){
            output.put("SMSid",ApiField.builder()
                    .value(sendSMSHandler.getResponse().getResult().getMsgID())
                    .status(FieldStatus.EXPLICITLY_CONFIRMED)
                    .build());
        }
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
