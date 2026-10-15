package cn.jiguang.api;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class JActionExtra {
    public Object beforLogin(Context context, int i9, String str) {
        return null;
    }

    public Object beforRegister(Context context, int i9, String str) {
        return null;
    }

    public boolean checkAction(int i9) {
        return true;
    }

    public Object onSendData(Context context, long j, long j8, int i9, int i10) {
        return null;
    }
}
