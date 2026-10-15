package com.heytap.mcssdk.liquid;

/* JADX INFO: loaded from: classes.dex */
public class SettingChangeBean {

    @LiquidConstants.b
    private int changeType;
    private int switchStatus;

    public int getChangeType() {
        return this.changeType;
    }

    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public void setChangeType(int i9) {
        this.changeType = i9;
    }

    public void setSwitchStatus(int i9) {
        this.switchStatus = i9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SettingChangeBean{changeType=");
        sb.append(this.changeType);
        sb.append(", switchStatus=");
        return H2.a.a(sb, this.switchStatus, '}');
    }
}
