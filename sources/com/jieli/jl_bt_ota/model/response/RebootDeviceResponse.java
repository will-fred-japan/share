package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class RebootDeviceResponse extends CommonResponse {
    private int result;

    public RebootDeviceResponse(int i9) {
        this.result = i9;
    }

    public int getResult() {
        return this.result;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return a.a(new StringBuilder("RebootDeviceResponse{result="), this.result, '}');
    }
}
