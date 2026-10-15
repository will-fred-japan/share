package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class CommandWithResponse<R extends CommonResponse> extends CommandBase<BaseParameter, R> {
    public CommandWithResponse(int i9, String str) {
        super(i9, str, 3);
    }
}
