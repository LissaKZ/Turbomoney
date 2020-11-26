package com.omilia;

import com.omilia.diamant.custommodule.CustomModuleAdaptor;
import com.omilia.diamant.custommodule.DataPooler;
import com.omilia.diamant.dialog.components.fields.ApiField;
import com.omilia.diamant.dialog.components.fields.FieldsContainer;
import com.omilia.diamant.loggers.GenericLogger;
import com.omilia.diamant.managers.DialogManager;
import com.omilia.samp.actions.SendSMSAction;

import javax.xml.soap.SOAPException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class CustomModule extends CustomModuleAdaptor {

    private Map<String, ApiField> output = new HashMap<String, ApiField>();
    private final String MODULE_NAME = "Sample_module";
    private FieldsContainer fieldsContainer;


    public Map<String, ApiField> applyCustomAction(String function, Map<String, ApiField> input){
        Map<String, ApiField> output = new HashMap<>();

        switch (function){
            case "SendSMS":
                SendSMSAction sendSMSAction=new SendSMSAction(input,logger,fieldsContainer);
                try {
                    sendSMSAction.process();
                } catch (SOAPException e) {
                    e.printStackTrace();
                }
                output=sendSMSAction.getOutput();
                break;
        }
        return output;
    }

    @Override
    public boolean onApplicationStart(Map<String, Object> map) {
        GenericLogger logger = DialogManager.getInstance().getLogger();
        logger.log(MODULE_NAME + " is started RU ");
        return true;
    }

    @Override
    public boolean onDialogStart(FieldsContainer fieldsContainer) {
        this.logger.log(this.MODULE_NAME + " CustomModule instance initialized");
        this.fieldsContainer = fieldsContainer;
        return true;
    }

    @Override
    public boolean onDialogClose() {
        this.logger.log(this.MODULE_NAME + " CustomModule instance closed");
        return true;
    }

    @Override
    public boolean onApplicationClose() {
        return true;
    }

    public DataPooler getCopy(){return new CustomModule();}
}
