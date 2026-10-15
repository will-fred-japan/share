package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class EnterUpdateModeResponse extends CommonResponse {
    private int canUpdateFlag;

    public EnterUpdateModeResponse(int i9) {
        this.canUpdateFlag = i9;
    }

    public int getCanUpdateFlag() {
        return this.canUpdateFlag;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return a.a(new StringBuilder("EnterUpdateModeResponse{canUpdateFlag="), this.canUpdateFlag, '}');
    }
}
