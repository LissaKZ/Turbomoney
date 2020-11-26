package com.omilia.samp.handlers;


import com.baeldung.springsoap.client.gen.SMSM;
import com.baeldung.springsoap.client.gen.SendSMSServiceSendMessage;
import com.baeldung.springsoap.client.gen.SendSMSServiceSendMessageResponse;
import com.omilia.diamant.loggers.DialogLogger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SendSMSHandler  extends WebServiceGatewaySupport implements Handler{
    protected static String login="ecasia";
    protected static String password="Uu0pwXtZt";
    protected DialogLogger logger;
    WebServiceTemplate client;
    String phone;
    String text;
    public SendSMSHandler(DialogLogger logger, String phone, String text) {
        this.phone=phone;
        this.text=text;
        this.logger = logger;
    }

    @Override
    public boolean initialize() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.baeldung.springsoap.client.gen");
        client = getWebServiceTemplate();
        client.setDefaultUri("https://isms.center/ru/soap/server");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return true;
    }
    private static SMSM createSMS(String text, String phone){
        SMSM sms = new SMSM();
        sms.setMsg(text);
        sms.setRecepient(phone);
        sms.setMsgtype(0);
        sms.setPrioritet(0);
        sms.setSenderid("TEXT_MSG");
        sms.setScheduled("");
        sms.setUserMsgID("");
        return sms;
    }
    private static SMSM createSMS(String text, String phone,String sender){
        SMSM sms = new SMSM();
        sms.setMsg(text);
        sms.setRecepient(phone);
        sms.setMsgtype(0);
        sms.setPrioritet(0);
        sms.setSenderid(sender);
        sms.setScheduled("");
        sms.setUserMsgID("");
        return sms;
    }
    static SendSMSServiceSendMessage getRequest(String text, String phone) {
        SendSMSServiceSendMessage request = new SendSMSServiceSendMessage();
        request.setLogin(login);
        request.setPassword(password);
        request.setSms(createSMS(text,phone));
        return request;
    }
    static SendSMSServiceSendMessage getRequest(String text, String phone,String sender) {
        SendSMSServiceSendMessage request = new SendSMSServiceSendMessage();
        request.setLogin(login);
        request.setPassword(password);
        request.setSms(createSMS(text,phone,sender));
        return request;
    }
     public SendSMSServiceSendMessageResponse getResponse(){
        return (SendSMSServiceSendMessageResponse) client.marshalSendAndReceive(getRequest(text,phone));
    }

    @Override
    public StringBuilder getParameterLog(String var1) {
        return null;
    }

    @Override
    public void logResponseStatus(String var1, String var2, String var3) {

    }

    @Override
    public String getEndpoint() {
        return null;
    }

    @Override
    public void activatePrintRqRsXml(Object var1) {

    }

    @Override
    public boolean isResponseValid(Object var1) {
        return false;
    }

}
