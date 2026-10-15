package com.hihonor.push.sdk.common;

import com.hihonor.push.sdk.e;
import com.hihonor.push.sdk.i;

/* JADX INFO: loaded from: classes.dex */
public class PushTokenResult implements e {

    @i
    private String pushToken = "";

    public String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }
}
