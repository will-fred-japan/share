package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class NotifyCommunicationWayResponse extends CommonResponse {
    private int flag;

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i9) {
        this.flag = i9;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return a.a(new StringBuilder("NotifyCommunicationWayResponse{flag="), this.flag, '}');
    }
}
