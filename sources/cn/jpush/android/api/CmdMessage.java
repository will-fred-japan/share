package cn.jpush.android.api;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class CmdMessage {
    public int cmd;
    public int errorCode;
    public Bundle extra;
    public String msg;

    public CmdMessage(int i9, int i10) {
        this.cmd = i9;
        this.errorCode = i10;
    }

    public String toString() {
        return "CmdMessage{cmd=" + this.cmd + ", errorCode=" + this.errorCode + ", msg='" + this.msg + "', extra=" + this.extra + '}';
    }

    public CmdMessage(int i9, int i10, String str) {
        this.cmd = i9;
        this.errorCode = i10;
        this.msg = str;
    }

    public CmdMessage(int i9, int i10, String str, Bundle bundle) {
        this.cmd = i9;
        this.errorCode = i10;
        this.msg = str;
        this.extra = bundle;
    }
}
