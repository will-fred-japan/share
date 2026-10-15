package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class CommandWithParamAndResponse<P extends BaseParameter, R extends CommonResponse> extends CommandBase<P, R> {
    public CommandWithParamAndResponse(int i9, String str, P p8) {
        super(i9, str, 2);
        setParam(p8);
    }
}
