package com.heytap.msp.push.callback;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ILiquidTaskQueryCallback {
    void onFailure(int i9);

    void onSuccess(List<String> list);
}
