package com.jieli.jl_bt_ota.model.parameter;

import H2.a;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;

/* JADX INFO: loaded from: classes.dex */
public class SettingsMtuParam extends BaseParameter {
    private int mtu;

    public SettingsMtuParam(int i9) {
        this.mtu = i9;
    }

    public int getMtu() {
        return this.mtu;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return CHexConver.int2byte2(this.mtu);
    }

    public void setMtu(int i9) {
        this.mtu = i9;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return a.a(new StringBuilder("SettingsMtuParam{mtu="), this.mtu, '}');
    }
}
