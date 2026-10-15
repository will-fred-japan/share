package com.jieli.jl_bt_ota.model.parameter;

import H2.a;
import com.jieli.jl_bt_ota.model.base.BaseParameter;

/* JADX INFO: loaded from: classes.dex */
public class RebootDeviceParam extends BaseParameter {
    private int param;

    public RebootDeviceParam(int i9) {
        this.param = i9;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.param};
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return a.a(new StringBuilder("RebootDeviceParam{param="), this.param, '}');
    }
}
