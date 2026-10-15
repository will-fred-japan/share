package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.parameter.CustomParam;
import com.jieli.jl_bt_ota.model.response.CustomResponse;

/* JADX INFO: loaded from: classes.dex */
public class CustomCmd extends CommandBase<CustomParam, CustomResponse> {
    public CustomCmd(CustomParam customParam) {
        this(2, customParam);
    }

    public CustomCmd(int i9, CustomParam customParam) {
        super(255, "CustomCmd", i9);
        setParam(customParam);
    }
}
