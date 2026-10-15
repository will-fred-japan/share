package com.jieli.jl_bt_ota.model.base;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public class CommonResponse extends BaseResponse {
    private int xmOpCode = -1;

    public int getXmOpCode() {
        return this.xmOpCode;
    }

    public CommonResponse setXmOpCode(int i9) {
        this.xmOpCode = i9;
        return this;
    }

    public String toString() {
        return a.a(new StringBuilder("CommonResponse{xmOpCode="), this.xmOpCode, '}');
    }
}
