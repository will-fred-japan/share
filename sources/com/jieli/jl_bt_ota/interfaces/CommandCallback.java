package com.jieli.jl_bt_ota.interfaces;

import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public interface CommandCallback<T extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> {
    void onCommandResponse(T t);

    void onErrCode(BaseError baseError);
}
