package com.omilia.samp.properties;

import com.omilia.diamant.dialog.components.fields.ApiField;
import com.omilia.diamant.dialog.components.fields.FieldStatus;

public class Results {
    public static final ApiField SUCCESS;
    public static final ApiField ERROR;

    private Results() {
    }
    static {
        SUCCESS = ApiField.builder().value("success").status(FieldStatus.DEFINED).build();
        ERROR = ApiField.builder().value("error").status(FieldStatus.DEFINED).build();
    }
}
