package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;

/* JADX INFO: loaded from: classes.dex */
public class InquireUpdateParam extends BaseParameter {
    private byte[] updateFileFlagData;

    public InquireUpdateParam(byte[] bArr) {
        setUpdateFileFlagData(bArr);
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return this.updateFileFlagData;
    }

    public byte[] getUpdateFileFlagData() {
        return this.updateFileFlagData;
    }

    public void setUpdateFileFlagData(byte[] bArr) {
        this.updateFileFlagData = bArr;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return "InquireUpdateParam{updateFileFlagData=" + CHexConver.byte2HexStr(this.updateFileFlagData) + '}';
    }

    public InquireUpdateParam() {
        this(new byte[0]);
    }
}
