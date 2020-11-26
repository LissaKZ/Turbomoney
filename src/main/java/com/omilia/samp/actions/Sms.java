package com.omilia.samp.actions;

import javax.xml.soap.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Sms {

    private static final Logger logger = LoggerFactory.getLogger(Sms.class);
    private static void createSoapEnvelope(SOAPMessage soapMessage,String phone,String text) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespaceURI = "http://tempuri.org/";

        SOAPEnvelope envelope = soapPart.getEnvelope();

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapElement=soapBody.addChildElement("SendSMSService___SendMessage","",myNamespaceURI);
        SOAPElement login=soapElement.addChildElement("login");
        login.addTextNode("ecasia");

        SOAPElement password=soapElement.addChildElement("password");
        password.addTextNode("Uu0pwXtZt");

        SOAPElement sms=soapElement.addChildElement("sms");
        SOAPElement recepient=sms.addChildElement("recepient");
        SOAPElement senderid=sms.addChildElement("senderid");
        SOAPElement msg=sms.addChildElement("msg");
        SOAPElement msgtype=sms.addChildElement("msgtype");
        SOAPElement scheduled=sms.addChildElement("scheduled");
        SOAPElement UserMsgID=sms.addChildElement("UserMsgID");
        SOAPElement prioritet=sms.addChildElement("prioritet");

        recepient.addTextNode(phone);
        senderid.addTextNode("TEXT_MSG");
        msg.addTextNode(text);
        msgtype.addTextNode("0");
        scheduled.addTextNode("");
        UserMsgID.addTextNode("");
        prioritet.addTextNode("1");

    }

    public static SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction,String phone,String text) {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction,phone,text), soapEndpointUrl);

            soapConnection.close();
            return soapResponse;
        } catch (Exception e) {
             e.printStackTrace();
        }

        return null;
    }

    private static SOAPMessage createSOAPRequest(String soapAction,String phone,String text) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage,phone,text);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();


        return soapMessage;
    }
}