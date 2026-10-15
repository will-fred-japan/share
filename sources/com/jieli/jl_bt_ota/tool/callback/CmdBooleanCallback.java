package com.jieli.jl_bt_ota.tool.callback;

import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* JADX INFO: loaded from: classes.dex */
public class CmdBooleanCallback extends CmdResultCallback<Boolean, CommandBase<?, ?>> {
    public CmdBooleanCallback(String str, IActionCallback<Boolean> iActionCallback) {
        super(str, iActionCallback, new IHandleResult<Boolean, CommandBase<?, ?>>() { // from class: com.jieli.jl_bt_ota.tool.callback.CmdBooleanCallback.1
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public /* bridge */ /* synthetic */ Boolean handleResult(CommandBase commandBase) {
                return handleResult((CommandBase<?, ?>) commandBase);
            }

            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase<?, ?> commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Boolean handleResult(CommandBase<?, ?> commandBase) {
                return Boolean.TRUE;
            }
        });
    }
}
