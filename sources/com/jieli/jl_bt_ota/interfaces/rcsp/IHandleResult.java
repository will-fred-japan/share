package com.jieli.jl_bt_ota.interfaces.rcsp;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public interface IHandleResult<T, C extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> {
    T handleResult(C c5);

    int hasResult(C c5);
}
