package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;

/* JADX INFO: loaded from: classes.dex */
public class DataParam extends BaseParameter {
    private final byte[] data;

    public DataParam(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        byte[] bArr = this.data;
        return bArr == null ? new byte[0] : bArr;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return "DataParam{data=" + CHexConver.byte2HexStr(this.data) + '}';
    }
}
