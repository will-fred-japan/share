package com.jieli.jl_bt_ota.model.parameter.tws;

import A.f;
import com.jieli.jl_bt_ota.model.base.BaseParameter;

/* JADX INFO: loaded from: classes.dex */
public class SetDeviceNotifyAdvInfoParam extends BaseParameter {
    private int op;

    public SetDeviceNotifyAdvInfoParam(int i9) {
        this.op = i9;
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.op};
    }

    public SetDeviceNotifyAdvInfoParam setOp(int i9) {
        this.op = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return f.i(new StringBuilder("SetDeviceNotifyAdvInfoParam{op="), this.op, "} ");
    }
}
