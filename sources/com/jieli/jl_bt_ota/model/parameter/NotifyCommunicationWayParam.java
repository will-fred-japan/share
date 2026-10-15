package com.jieli.jl_bt_ota.model.parameter;

import H2.a;
import com.jieli.jl_bt_ota.model.base.BaseParameter;

/* JADX INFO: loaded from: classes.dex */
public class NotifyCommunicationWayParam extends BaseParameter {
    private final int reconnect;
    private final int way;

    public NotifyCommunicationWayParam(int i9, int i10) {
        this.way = i9;
        this.reconnect = i10;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.way, (byte) this.reconnect};
    }

    public int getReconnect() {
        return this.reconnect;
    }

    public int getWay() {
        return this.way;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        StringBuilder sb = new StringBuilder("NotifyCommunicationWayParam{way=");
        sb.append(this.way);
        sb.append(", reconnect=");
        return a.a(sb, this.reconnect, '}');
    }
}
