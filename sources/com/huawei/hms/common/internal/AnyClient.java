package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

/* JADX INFO: loaded from: classes.dex */
public interface AnyClient {

    public interface CallBack {
        void onCallback(IMessageEntity iMessageEntity, String str);
    }

    void connect(int i9);

    void connect(int i9, boolean z8);

    void disconnect();

    int getRequestHmsVersionCode();

    String getSessionId();

    boolean isConnected();

    boolean isConnecting();

    void post(IMessageEntity iMessageEntity, String str, CallBack callBack);
}
