package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.util.CHexConver;

/* JADX INFO: loaded from: classes.dex */
public class CustomResponse extends CommonResponse {
    private byte[] data;

    public CustomResponse(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public CustomResponse setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return "CustomResponse{data=" + CHexConver.byte2HexStr(this.data) + '}';
    }

    public CustomResponse() {
        this(new byte[0]);
    }
}
