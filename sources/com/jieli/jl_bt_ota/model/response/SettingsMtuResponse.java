package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class SettingsMtuResponse extends CommonResponse {
    private int realMtu;

    public SettingsMtuResponse(int i9) {
        this.realMtu = i9;
    }

    public int getRealMtu() {
        return this.realMtu;
    }

    public SettingsMtuResponse setRealMtu(int i9) {
        this.realMtu = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return a.a(new StringBuilder("SettingsMtuResponse{realMtu="), this.realMtu, '}');
    }
}
