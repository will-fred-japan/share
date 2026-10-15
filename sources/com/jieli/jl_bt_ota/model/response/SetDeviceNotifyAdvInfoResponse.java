package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class SetDeviceNotifyAdvInfoResponse extends CommonResponse {
    private int result;

    public SetDeviceNotifyAdvInfoResponse(int i9) {
        this.result = i9;
    }

    public int getResult() {
        return this.result;
    }

    public SetDeviceNotifyAdvInfoResponse setResult(int i9) {
        this.result = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return a.a(new StringBuilder("SetDeviceNotifyAdvInfoResponse{result="), this.result, '}');
    }
}
