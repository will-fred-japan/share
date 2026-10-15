package com.jieli.jl_bt_ota.tool.callback;

import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.constant.StateCode;
import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.util.CommonUtil;

/* JADX INFO: loaded from: classes.dex */
public class CmdResultCallback<T, C extends CommandBase<? extends BaseParameter, ? extends CommonResponse>> implements CommandCallback<C> {
    protected final IActionCallback<T> callback;
    protected final String funcName;
    protected final IHandleResult<T, C> handle;

    public CmdResultCallback(String str, IActionCallback<T> iActionCallback, IHandleResult<T, C> iHandleResult) {
        if (iHandleResult == null) {
            throw new NullPointerException("IHandleResult is null.");
        }
        this.funcName = str;
        this.callback = iActionCallback;
        this.handle = iHandleResult;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.CommandCallback
    public void onCommandResponse(C c5) {
        if (c5 == null) {
            return;
        }
        if (c5.getStatus() != 0) {
            onErrCode(OTAError.buildError(ErrorCode.SUB_ERR_RESPONSE_BAD_STATUS, c5.getStatus(), "status = " + StateCode.printStatusCode(c5.getStatus())).setOpCode(c5.getId()).setCmdSn(c5.getOpCodeSn()));
            return;
        }
        int iHasResult = this.handle.hasResult(c5);
        if (iHasResult != 0) {
            onErrCode(OTAError.buildError(12298, iHasResult, "result = " + iHasResult).setOpCode(c5.getId()).setCmdSn(c5.getOpCodeSn()));
        } else {
            T tHandleResult = this.handle.handleResult(c5);
            IActionCallback<T> iActionCallback = this.callback;
            if (iActionCallback != null) {
                iActionCallback.onSuccess(tHandleResult);
            }
        }
    }

    @Override // com.jieli.jl_bt_ota.interfaces.CommandCallback
    public void onErrCode(BaseError baseError) {
        CommonUtil.callbackError(getClass().getSimpleName(), this.funcName, this.callback, baseError);
    }
}
