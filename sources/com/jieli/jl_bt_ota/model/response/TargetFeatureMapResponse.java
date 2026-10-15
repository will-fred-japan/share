package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class TargetFeatureMapResponse extends CommonResponse {
    private int mask;

    public TargetFeatureMapResponse() {
        this(0);
    }

    public int getMask() {
        return this.mask;
    }

    public void setMask(int i9) {
        this.mask = i9;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return a.a(new StringBuilder("TargetFeatureMapResponse{mask="), this.mask, '}');
    }

    public TargetFeatureMapResponse(int i9) {
        setMask(i9);
    }
}
