package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.model.base.BaseParameter;

/* JADX INFO: loaded from: classes.dex */
public class CommandWithParam<P extends BaseParameter> extends CommandBase<P, CommonResponse> {
    public CommandWithParam(int i9, String str, P p8) {
        super(i9, str, 1);
        setParam(p8);
    }
}
